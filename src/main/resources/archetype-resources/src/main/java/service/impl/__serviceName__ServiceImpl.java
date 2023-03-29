package ${package}service.impl;

import ${package}.model.*;
import ${package}.repository.PlantRepository;
import ${package}.service.${serviceName};

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ${serviceName}ServiceImpl implements ${serviceName}Service {
    private ${serviceName}Repository ${serviceName.toLowerCase()}Repository;

    public ${serviceName}ServiceImpl(${serviceName}Repository ${serviceName.toLowerCase()}Repository) {
        this.${serviceName.toLowerCase()}Repository = ${serviceName.toLowerCase()}Repository;
    }

    @Override
    public List<${modelClass}> get${modelClass}s(String id) {
        return ${serviceName.toLowerCase()}Repository.get${modelClass}s(id);
    }
}
