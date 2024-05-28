package com.example.IdentityService.mapper;

import com.example.IdentityService.dto.request.RoleRequest;
import com.example.IdentityService.dto.response.RoleResponse;
import com.example.IdentityService.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
