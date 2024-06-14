package com.CleverBuddy.controller;

import com.cleverbuddy.model.User;
import com.cleverbuddy.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return authService.authenticateUser(user.getUsername(), user.getPassword());
    }
}
