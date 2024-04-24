package com.example.simpleecommerce.model.mapper;

//import com.example.simpleecommerce.model.dto.reponse.UserDtoResponse;
//import com.example.simpleecommerce.model.dto.request.UserLoginRequest;
//import com.example.simpleecommerce.model.dto.request.UserRegisterRequest;
import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.dto.UserRegisterRequest;

public class UserMapper {
//    public static User UserDtoResponsetoEntity(UserDtoResponse userDto) {
//        User user = new User();
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setUsername(userDto.getUsername());
//        user.setRoleUser(userDto.getRole());
//        return user;
//    }
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
//    public static UserDtoResponse toDtoResponse(User user) {
//        return UserDtoResponse.builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .username(user.getUsername())
//                .role(user.getRoleUser())
//                .build();
//    }
//    public static UserDtoResponse UserToUserDto(User user) {
//        UserDtoResponse userDtoResponse = new UserDtoResponse();
//        userDtoResponse.setId(user.getId());
//        userDtoResponse.setFirstName(user.getFirstName());
//        userDtoResponse.setLastName(user.getLastName());
//        userDtoResponse.setUsername(user.getUsername());
//        userDtoResponse.setEmail(user.getEmail());
//        userDtoResponse.setPhone(user.getPhone());
//        userDtoResponse.setRole(user.getRoleUser());
//        return userDtoResponse;
//    }
}
