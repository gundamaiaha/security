package com.example.csrfApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@CrossOrigin
@RestController
public class GreetingController {

    @GetMapping("/resource")
    public Map<String,Object> home(){
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content","Hello World!");
        return model;
    }
}
