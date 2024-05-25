package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.UserResponse;
import com.example.IdentityService.exception.AppException;
import com.example.IdentityService.exception.ErrorCode;
import com.example.IdentityService.mapper.UserMapper;
import com.example.IdentityService.model.User;
import com.example.IdentityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserResponse createRequest(UserCreation userCreation) {

        if (userRepository.existsByUsername(userCreation.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(userCreation);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getUsers() {
        return userMapper.toListUserResponse(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) return userMapper.toUserResponse(userOptional.get());
        else throw new AppException(ErrorCode.USER_NOT_FOUND);
    }

    @Override
    public UserResponse updateUserById(Long id, UserUpdate userUpdate) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, userUpdate);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
        } else {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }
    }
}
