package com.example.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class AppController {

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Welcome to Users Service home. Login to check your details!!!");
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome to Users Service !!!");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/welcome-admin")
    public ResponseEntity<String> welcomeAdmin(){
        return ResponseEntity.ok("Welcome Admin!!!");
    }




}
