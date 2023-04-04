package ${package}.repository.impl;

import ${package}.io.JsonUtils;
import ${package}.model.*;
import ${package}.repository.${serviceName}Repository;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ${serviceName}RepositoryImpl implements ${serviceName}Repository {
    @Override
    public List<${modelClass}> get${modelClass}s(${primaryKeyType} id) {
        log.info("get${modelClass}s(${primaryKeyType} {}) ", id);
        List<${modelClass}> ${modelClass.toLowerCase()}s = new ArrayList<>();
        ${modelClass} ${modelClass.toLowerCase()} = new ${modelClass}();
        ${modelClass.toLowerCase()}.setId(id);
        ${modelClass.toLowerCase()}s.add(${modelClass.toLowerCase()});
        return ${modelClass.toLowerCase()}s;
    }
}
