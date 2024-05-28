package com.example.IdentityService.mapper;

import com.example.IdentityService.dto.request.PermissionRequest;
import com.example.IdentityService.dto.response.PermissionResponse;
import com.example.IdentityService.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}
