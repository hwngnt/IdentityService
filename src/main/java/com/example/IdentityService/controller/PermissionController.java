package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.PermissionRequest;
import com.example.IdentityService.dto.response.ApiResponse;
import com.example.IdentityService.dto.response.PermissionResponse;
import com.example.IdentityService.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest permissionRequest) {
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.createPermission(permissionRequest))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getPermissions())
                .build();
    }

    @DeleteMapping("/{permission}")
    public ApiResponse<String> deletePermission(@PathVariable String permission) {
        permissionService.deletePermission(permission);
        return ApiResponse.<String>builder()
                .result("Permission has been deleted")
                .build();
    }
}
