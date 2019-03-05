package com.example.swagger.infrastructure.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by mtumilowicz on 2018-07-04.
 */
@Configuration
@EnableSwagger2
@AllArgsConstructor
public class SwaggerConfig {
    
    private final SwaggerProperties swaggerProperties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.isEnabled())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.app.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Swagger")
                .description("\"Testing Swagger\"")
                .version("0.0.1-SNAPSHOT")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Michal Tumilowicz", 
                        "https://www.linkedin.com/in/mtumilowicz/", 
                        "michal.tumilowicz01@gmail.com"))
                .build();
    }
}
