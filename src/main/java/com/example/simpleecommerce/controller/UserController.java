package com.example.simpleecommerce.controller;

import com.example.simpleecommerce.auth.JwtUtil;
import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.mapper.UserMapper;
import com.example.simpleecommerce.model.request.UserRegisterRequest;
import com.example.simpleecommerce.model.response.ErrorRes;
import com.example.simpleecommerce.service.UserService;
import com.example.simpleecommerce.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/rest/auth/new/user")
    public ResponseEntity<?> createUser(@RequestBody UserRegisterRequest userLoginRequest)
    {
        Response<String> userDtoResponseResponse = new Response<>();
        try {
            User user = UserMapper.UserRegisterRequestToEntity(userLoginRequest);
            user.setEmail(userLoginRequest.getEmail());
            userService.saveUserRoleAdmin(user);
            user.setId(userService.findIdByEmail(user.getEmail()));
            String token = jwtUtil.createToken(user);
            userDtoResponseResponse.setMessage("User has been added");
            userDtoResponseResponse.setResult(token);
            return ResponseEntity.ok(userDtoResponseResponse);
        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid email or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
