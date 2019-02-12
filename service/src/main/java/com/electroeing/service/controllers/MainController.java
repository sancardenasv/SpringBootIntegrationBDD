package com.electroeing.service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Value("${application.enabled}")
    private boolean enabled;

    @RequestMapping(method = RequestMethod.GET, path = "greet")
    public String greet() {
        if (enabled) {
            return "Hello World!";
        } else {
            return "Unauthorized";
        }
    }
}
