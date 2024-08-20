package com.security.web_security.controller;

import com.security.web_security.httpRequest.UserRequest;
import com.security.web_security.model.User;
import com.security.web_security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/public/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequest userRequest) {
        if (userService.findByUsername(userRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.registerUser(userRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/private/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
