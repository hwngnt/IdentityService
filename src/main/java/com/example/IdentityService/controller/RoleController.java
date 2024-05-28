package com.example.IdentityService.controller;

import com.example.IdentityService.dto.request.RoleRequest;
import com.example.IdentityService.dto.response.ApiResponse;
import com.example.IdentityService.dto.response.RoleResponse;
import com.example.IdentityService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ApiResponse<RoleResponse> createPermission(@RequestBody RoleRequest roleRequest) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(roleRequest))
                .build();
    }

    @GetMapping
    public ApiResponse<List<RoleResponse>> getPermissions() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getRoles())
                .build();
    }

    @DeleteMapping("/{role}")
    public ApiResponse<String> deletePermission(@PathVariable String role) {
        roleService.deleteRole(role);
        return ApiResponse.<String>builder()
                .result("Role has been deleted")
                .build();
    }
}
