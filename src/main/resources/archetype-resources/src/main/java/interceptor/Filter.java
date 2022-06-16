package ${package}.interceptor;

import ${package}.interceptor.dto.LoggerDto;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter extends GenericFilterBean {

    private static final Logger LOG = LoggerFactory.getLogger(Filter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoggerDto loggerDto = LoggerDto.getInstance();
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            wrappedRequest.getInputStream();

            filterChain.doFilter(wrappedRequest, responseWrapper);
            byte[] responseArray=responseWrapper.getContentAsByteArray();
            String responseStr=new String(responseArray,responseWrapper.getCharacterEncoding());
            loggerDto.setParametersOut(responseStr);
            loggerDto.setCodeResponse(String.valueOf(res.getStatus()));
            responseWrapper.copyBodyToResponse();
            LOG.info("LOG:"+loggerDto.toString());
        }catch (Exception e) {

            byte[] responseArray=responseWrapper.getContentAsByteArray();
            String responseStr=new String(responseArray,responseWrapper.getCharacterEncoding());
            loggerDto.setParametersOut(responseStr);
            loggerDto.setCodeResponse(String.valueOf(responseWrapper.getStatus()));
            String stacktrace = ExceptionUtils.getStackTrace(e).substring(1, 500);
            loggerDto.setDetailTrace(stacktrace);
            responseWrapper.copyBodyToResponse();
            LOG.info("LOG catch:"+loggerDto.toString());
            throw e;
        }
    }
}