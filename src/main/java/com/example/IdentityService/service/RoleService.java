package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.RoleRequest;
import com.example.IdentityService.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse createRole(RoleRequest roleRequest);
    List<RoleResponse> getRoles();
    void deleteRole(String role);
}
