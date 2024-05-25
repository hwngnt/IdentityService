package com.example.IdentityService.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ApiResponse <T>{
    @Builder.Default
    private int code = 1000;
    private String message;
    private T result;
}
