package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.AuthenticationRequest;
import com.example.IdentityService.dto.response.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
