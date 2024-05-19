package com.example.simpleecommerce.model.mapper;

import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.dto.UserRegisterRequest;
import com.example.simpleecommerce.model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User UserRegisterRequestToEntity(UserRegisterRequest userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPhone(userDto.getPhone());
        return user;
    }

    public static List<UserResponse> UserListToUserResponseList(List<User> users)
    {
        List<UserResponse> responses = new ArrayList<>();
        for (User user: users)
        {
            UserResponse response = new UserResponse();
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setEmail(user.getEmail());
            response.setRoleUser(user.getRoleUser());
            responses.add(response);
        }
        return responses;
    }

    public static UserResponse UserToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
