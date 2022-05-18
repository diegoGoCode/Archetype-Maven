package ${package}.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${package}.dominio.dto.TestDto;
import ${package}.dominio.service.TestService;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestDto> test(){
        return ResponseEntity.ok(testService.test());
    }
}