package com.example.IdentityService.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User existed."),
    USER_NOT_FOUND(1002, "User not found"),
    PASSWORD_INVALID(1003, "Password must be at least 6 characters"),
    UNCATEGORIZED_ERROR(9999, "Uncategorized error")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
