package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    public UserResponse createRequest(UserCreation userCreation);
    public List<UserResponse> getUsers();
    public UserResponse getUserById(Long id);
    public UserResponse updateUserById(Long id, UserUpdate userUpdate);
    public void deleteUser(Long id);
    public UserResponse getMyInfo();
}
