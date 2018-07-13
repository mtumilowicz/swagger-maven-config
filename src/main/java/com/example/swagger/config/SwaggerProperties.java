package com.example.swagger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

/**
 * Created by mtumilowicz on 2018-07-13.
 */
@Configuration
@ConfigurationProperties("swagger")
@Getter
@Setter
public class SwaggerProperties {
    @NotBlank
    private boolean enabled;
}
