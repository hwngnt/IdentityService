package com.example.IdentityService.mapper;

import com.example.IdentityService.dto.request.UserCreation;
import com.example.IdentityService.dto.request.UserUpdate;
import com.example.IdentityService.dto.response.UserResponse;
import com.example.IdentityService.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreation userCreation);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdate userUpdate);
    UserResponse toUserResponse(User user);
    List<UserResponse> toListUserResponse(List<User> users);
}
