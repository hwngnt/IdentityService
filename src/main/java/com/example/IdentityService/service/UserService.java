package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User createRequest(UserCreation userCreation);
    public List<User> getUsers();
    public User getUserById(Long id);
    public User updateUserById(Long id, UserUpdate userUpdate);
    public void deleteUser(Long id);
}
