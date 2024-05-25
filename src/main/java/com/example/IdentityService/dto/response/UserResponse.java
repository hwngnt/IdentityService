package com.example.IdentityService.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserResponse {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
