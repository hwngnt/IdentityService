package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.PermissionRequest;
import com.example.IdentityService.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    PermissionResponse createPermission(PermissionRequest permissionRequest);
    List<PermissionResponse> getPermissions();
    void deletePermission(String permission);
}
