package com.diwanga.restapidemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}") // from application,properties file
    private String welcomeMessage;

//@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String getMapper(){
        return welcomeMessage;
    }
}
