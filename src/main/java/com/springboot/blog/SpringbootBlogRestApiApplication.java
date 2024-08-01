package com.springboot.blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Spring Boot Blog App REST APIs",
        description = "Spring Boot Blog App REST APIs Documentation",
        version = "v1.0",
        contact = @Contact(
                name = "Sajal Devnath",
                email = "sajaldevnath96@gmail.com",
                url = "https://www.springbootblogapplication.com"
        ),
        license = @License(
                name = "Apache 2.0",
                url = "https://www.springbootblogapplication.com/license"
        )
),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Blog Application Documentation",
                url = "https://github.com/SajalDevnath/SpringBoot-Blog-Application"
        )
)
public class SpringbootBlogRestApiApplication {

    @Bean       // - Indicates that a method produces a bean to be managed by the Spring container.
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
    }

}
