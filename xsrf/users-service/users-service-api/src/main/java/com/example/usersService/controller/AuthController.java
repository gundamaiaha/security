package com.example.usersService.controller;

import com.example.usersService.model.User;
import com.example.usersService.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody final User user) {
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/login").build().toUri();
        authService.registerUser(user);
        return ResponseEntity.created(location).body("You are successfully registered!!!");

    }


}
