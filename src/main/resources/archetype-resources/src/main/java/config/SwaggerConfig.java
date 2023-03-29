package ${package}.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        String contactName = "Chuck Hutchinson";
        String linkedInURL = "https://www.linkedin.com/in/hutchinsonchuck/";
        String licenseURL = "https://raw.githubusercontent.com/chuckhutchinson2/raisedbed/main/LICENSE.txt";
        return new OpenAPI().info(
                new Info().title("${name}")
                        .description("${description}")
                        .summary("This is a sample spring boot REST application with Jacoco, Swagger showing a sample Controller, Service and Repository")
                        .version("v1.0")
                        .contact(new Contact().name(contactName).url(linkedInURL))
                        .license(new License().url(licenseURL))
        ).addServersItem(new Server().url("/"));
    }
}
