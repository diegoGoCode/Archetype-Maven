package ${package}.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final GeneralInterceptor generalInterceptor;

    public WebConfiguration(GeneralInterceptor generalInterceptor) {
        this.generalInterceptor = generalInterceptor;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(generalInterceptor);
    }
}