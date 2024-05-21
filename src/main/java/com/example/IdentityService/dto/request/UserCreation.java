package com.example.IdentityService.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserCreation {
    private String username;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
