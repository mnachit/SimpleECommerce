package com.example.simpleecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    //return hello world
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
