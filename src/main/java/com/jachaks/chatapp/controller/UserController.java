package com.jachaks.chatapp.controller;

import com.jachaks.chatapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        redisTemplate.opsForHash().put("USER", user.getUsername(), user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User storedUser = (User) redisTemplate.opsForHash().get("USER", user.getUsername());
        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
