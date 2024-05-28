package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.ApiResponse;
import com.example.IdentityService.dto.response.UserResponse;
import com.example.IdentityService.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreation userCreation) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createRequest(userCreation))
                .build();
    }

    @PostAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        log.info("In getUsers");
        log.info(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {
        log.info("In getUserById");
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .build();
    }

    @GetMapping("/my-info")
    public ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

//    @PostAuthorize("returnObject.username == authentication.name")
    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUserById(@PathVariable Long id,
                               @RequestBody UserUpdate userUpdate) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUserById(id, userUpdate))
                .build();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }


}
