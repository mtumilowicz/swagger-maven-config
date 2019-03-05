package com.example.swagger.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

/**
 * Created by mtumilowicz on 2018-07-13.
 */
@Configuration
@ConfigurationProperties("swagger")
@EnableConfigurationProperties(SwaggerProperties.class)
@Getter
@Setter // otherwise exception during boot: Reason: No setter found for property: enabled
public class SwaggerProperties {
    @NotBlank
    private boolean enabled;
}
