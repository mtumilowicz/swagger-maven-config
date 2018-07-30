package com.example.swagger.domain.greeting.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by mtumilowicz on 2018-07-04.
 */
@Data
public class Greeting {
    private String message;
    
    @ApiModelProperty(notes = "Name that will be greeted", required = true)
    private String name;
}
