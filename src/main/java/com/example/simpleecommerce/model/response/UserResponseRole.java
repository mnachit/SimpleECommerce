package com.example.simpleecommerce.model.response;

import com.example.simpleecommerce.model.enums.RoleUser;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseRole {
    private String email;
    private RoleUser roleUser;
}
