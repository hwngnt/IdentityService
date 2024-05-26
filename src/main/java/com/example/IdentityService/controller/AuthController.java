package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.AuthenticationRequest;
import com.example.IdentityService.dto.response.ApiResponse;
import com.example.IdentityService.dto.response.AuthenticationResponse;
import com.example.IdentityService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authService.authenticate(request))
                .build();
    }
}
