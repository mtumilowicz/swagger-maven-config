package com.example.swagger.app.rest;

import com.example.swagger.domain.greeting.model.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-07-30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    
    @Test
    public void generic_status() {
        assertThat(restTemplate
                        .getForEntity(createURLWithPort("/"),
                                String.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }

    @Test
    public void generic_entity() {
        assertThat(restTemplate
                        .getForObject(createURLWithPort("/"),
                                String.class),
                is("Greetings!"));
    }

    @Test
    public void personalised_status() {
        assertThat(restTemplate
                        .postForEntity(createURLWithPort("/"),
                                "mtu",
                                String.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }

    @Test
    public void personalised_entity() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Greetings");
        greeting.setName("mtu");
        
        assertThat(restTemplate
                        .postForObject(createURLWithPort("/"),
                                "mtu",
                                Greeting.class),
                is(greeting));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}