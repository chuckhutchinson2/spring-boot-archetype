package ${package}.service.impl;

import ${package}.model.*;
import ${package}.repository.${serviceName}Repository;
import ${package}.service.${serviceName}Service;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Component
@Slf4j
public class ${serviceName}ServiceImpl implements ${serviceName}Service {
    private ${serviceName}Repository ${serviceName.toLowerCase()}Repository;

    public ${serviceName}ServiceImpl(${serviceName}Repository ${serviceName.toLowerCase()}Repository) {
        this.${serviceName.toLowerCase()}Repository = ${serviceName.toLowerCase()}Repository;
    }

    @Override
    public List<${modelClass}> get${modelClass}s(${primaryKeyType} id) {
        log.info("get${modelClass}s(${primaryKeyType} {}) ", id);
        return ${serviceName.toLowerCase()}Repository.get${modelClass}s(id);
    }
}
