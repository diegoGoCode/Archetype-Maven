package ${package}.dominio.service;

import ${package}.dominio.dto.TestDto;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Override
    public TestDto test(){
        return TestDto.builder().message("Test success...").build();
    }
}