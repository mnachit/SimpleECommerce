package com.example.simpleecommerce.model.dto;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Enabled
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
}
