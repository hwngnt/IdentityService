package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.model.User;
import com.example.IdentityService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody @Valid UserCreation userCreation) {
        return userService.createRequest(userCreation);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Long id,
                               @RequestBody UserUpdate userUpdate) {
        return userService.updateUserById(id, userUpdate);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
