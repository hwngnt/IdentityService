package com.example.IdentityService.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class RoleResponse {
    private String name;
    private String description;
    private Set<PermissionResponse> permissions;
}
