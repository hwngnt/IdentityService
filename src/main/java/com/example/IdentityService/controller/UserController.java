package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.ApiResponse;
import com.example.IdentityService.dto.response.UserResponse;
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
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreation userCreation) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createRequest(userCreation))
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUserById(@PathVariable Long id,
                               @RequestBody UserUpdate userUpdate) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUserById(id, userUpdate))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }
}
