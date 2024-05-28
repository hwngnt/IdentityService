package com.example.IdentityService.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserUpdate {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private List<String> roles;
}
