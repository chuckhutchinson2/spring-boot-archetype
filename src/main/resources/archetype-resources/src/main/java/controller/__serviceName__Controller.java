package ${package}.controller;

import ${package}.model.*;
import ${package}.service.${serviceName}Service;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/swagger-ui.html
@Slf4j
@RestController
@RequestMapping("${restEndpoint}")
public class ${serviceName}Controller {
    private ${serviceName}Service ${serviceName.toLowerCase()}Service;
    public ${serviceName}Controller(${serviceName}Service ${serviceName.toLowerCase()}Service) {
        this.${serviceName.toLowerCase()}Service = ${serviceName.toLowerCase()}Service;
    }

    @GetMapping("/${modelClass.toLowerCase()}s/{id}")
    ResponseEntity<List<${modelClass}>> getPlants(@PathVariable String id) {
        List<${modelClass}> ${modelClass.toLowerCase()}s = ${serviceName.toLowerCase()}Service.getPlants(id);

        return new ResponseEntity<>(${modelClass.toLowerCase()}s, HttpStatus.OK);
    }
}
