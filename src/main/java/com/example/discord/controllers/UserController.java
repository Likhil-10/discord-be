package com.example.discord.controllers;

import com.example.discord.entity.User;
import com.example.discord.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // POST method to register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);  // Save the user to the database
        return "User registered successfully!";
    }

    // GET method to get a user by ID (for testing purposes)
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}