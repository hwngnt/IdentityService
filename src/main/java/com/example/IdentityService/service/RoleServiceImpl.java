package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.RoleRequest;
import com.example.IdentityService.dto.response.RoleResponse;
import com.example.IdentityService.mapper.RoleMapper;
import com.example.IdentityService.model.Permission;
import com.example.IdentityService.model.Role;
import com.example.IdentityService.repository.PermissionRepository;
import com.example.IdentityService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {
        Role role = roleMapper.toRole(roleRequest);
        List<Permission> permissions = permissionRepository.findAllById(roleRequest.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteRole(String role) {
        roleRepository.deleteById(role);
    }
}
