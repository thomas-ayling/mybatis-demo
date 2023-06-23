package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    private ResponseEntity<?> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> get(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.get(id));
    }

    @GetMapping("/")
    private ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }
}
