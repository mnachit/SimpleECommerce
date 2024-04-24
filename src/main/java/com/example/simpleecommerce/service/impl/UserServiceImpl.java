package com.example.simpleecommerce.service.impl;

import com.example.simpleecommerce.exception.ValidationException;
import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.enums.RoleUser;
import com.example.simpleecommerce.repository.UserRepository;
import com.example.simpleecommerce.service.UserService;
import com.example.simpleecommerce.util.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public String generateUsername(String firstName, String lastName) {
        String usernameBase = firstName.substring(0, 1).toLowerCase() + lastName.toLowerCase();
        if (userRepository.findByUsername(usernameBase).isEmpty()) {
            return usernameBase;
        }
        else {
            int i = 1;
            while (userRepository.findByUsername(usernameBase + i).isPresent()) {
                i++;
            }
            return usernameBase + i;
        }
    }
    @Override
    public User saveUserRoleAdmin(User user) throws ValidationException {
        user.setUsername(generateUsername(user.getFirstName(), user.getLastName()));
        List<ErrorMessage> errorMessages = new ArrayList<>();
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            errorMessages.add(ErrorMessage.builder().message("Email already exists").build());
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            errorMessages.add(ErrorMessage.builder().message("Username already exists").build());
        if (errorMessages.size() > 0)
            throw new ValidationException(errorMessages);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoleUser(RoleUser.USER);
        Date date = new Date();
        user.setCreatedAt(date);
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean isPasswordValid(String rawPassword, String encodedPassword) {
        return false;
    }

    @Override
    public User updateUser(User user) throws ValidationException {
        return null;
    }

    @Override
    public User findByEmail(String email) throws ValidationException {
        return null;
    }

    @Override
    public boolean findByEmailAndPassword(String email, String password) throws ValidationException {
        return false;
    }

    @Override
    public User findByID(Long id) throws ValidationException {
        return null;
    }

    @Override
    public Long findIdByEmail(String email) throws ValidationException {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) throws ValidationException {
        return null;
    }
}
