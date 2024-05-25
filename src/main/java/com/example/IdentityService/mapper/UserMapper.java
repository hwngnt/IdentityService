package com.example.IdentityService.mapper;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.UserResponse;
import com.example.IdentityService.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreation userCreation);
    void updateUser(@MappingTarget User user, UserUpdate userUpdate);
    UserResponse toUserResponse(User user);
    List<UserResponse> toListUserResponse(List<User> users);
}
