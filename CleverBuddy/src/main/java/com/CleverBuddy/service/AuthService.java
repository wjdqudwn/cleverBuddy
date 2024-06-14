package com.CleverBuddy.service;

import com.cleverbuddy.model.User;
import com.cleverbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

    public String register(UserRegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return "Username already exists";
        }
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());
        userRepository.save(newUser);
        return "User registered successfully";
    }
}

class UserLoginRequest {
    private String username;
    private String password;

    // Getters and Setters
}

class UserRegisterRequest {
    private String username;
    private String password;
    private String email;

    // Getters and Setters
}
