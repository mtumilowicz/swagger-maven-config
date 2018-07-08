package com.example.swagger.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by mtumilowicz on 2018-07-04.
 */
@Getter
@Setter
public class Greeting {
    private String message;
    
    @ApiModelProperty(notes = "Name that will be greeted", required = true)
    private String name;
}
