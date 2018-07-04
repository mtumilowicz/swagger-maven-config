package com.example.swagger.api;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mtumilowicz on 2018-07-04.
 */
public class Greeting {
    private String message;
    @ApiModelProperty(notes = "Name that will be greeted", required = true)
    private String name;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
