package com.example.IdentityService.service;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.exception.AppException;
import com.example.IdentityService.exception.ErrorCode;
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

    @Override
    public User createRequest(UserCreation userCreation) {

        if (userRepository.existsByUsername(userCreation.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = new User();
        user.setUsername(userCreation.getUsername());
        user.setPassword(userCreation.getPassword());
        user.setFirstName(userCreation.getFirstName());
        user.setLastName(userCreation.getLastName());
        user.setDob(userCreation.getDob());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) return userOptional.get();
        else throw new AppException(ErrorCode.USER_NOT_FOUND);
    }

    @Override
    public User updateUserById(Long id, UserUpdate userUpdate) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(userUpdate.getPassword());
            user.setFirstName(userUpdate.getFirstName());
            user.setLastName(userUpdate.getLastName());
            user.setDob(userUpdate.getDob());
            return userRepository.save(user);
        } else {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }
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
