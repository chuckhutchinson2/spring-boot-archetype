package ${package}.repository.impl;

import ${package}.model.*;
import ${package}.repository.${serviceName}Repository;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
@ActiveProfiles("test")
@Slf4j
public class ${serviceName}RepositoryImplTest {

    private ${serviceName}RepositoryImpl  ${serviceName.toLowerCase()}Repository = new ${serviceName}RepositoryImpl();

    @Test
    public void testGet${modelClass}s() {
        ${primaryKeyType} ${primaryKeyType.toLowerCase()} = new ${primaryKeyType}("0");

        List<${modelClass}> ${modelClass.toLowerCase()}s = ${serviceName.toLowerCase()}Repository.get${modelClass}s(${primaryKeyType.toLowerCase()});
        assertNotNull(${modelClass.toLowerCase()}s);
        assertTrue(${modelClass.toLowerCase()}s.size() > 0);
    }
}
