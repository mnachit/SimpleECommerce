package com.example.simpleecommerce.model.response;

import com.example.simpleecommerce.model.enums.RoleUser;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private RoleUser roleUser;
}
