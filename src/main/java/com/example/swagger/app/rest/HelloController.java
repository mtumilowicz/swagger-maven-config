package com.example.swagger.app.rest;

import com.example.swagger.domain.greeting.model.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-07-04.
 */
@RestController
@Api(value="hello", description="Saying hello to everybody.")
public class HelloController {

    @ApiOperation(value = "Greeting message.")
    @GetMapping("/")
    public String generic() {
        return "Greetings!";
    }

    @ApiOperation(value = "Greeting message.")
    @PostMapping("/")
    public ResponseEntity<Greeting> personalised(@RequestBody String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("Greetings");
        greeting.setName(name);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @ApiOperation(value = "Test if controller is up.")
    @GetMapping("/health")
    public boolean health() {
        return true;
    }

}
