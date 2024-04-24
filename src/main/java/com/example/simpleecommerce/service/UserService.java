package com.example.simpleecommerce.service;

import com.example.simpleecommerce.exception.ValidationException;
import com.example.simpleecommerce.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUserRoleAdmin(User user) throws ValidationException;
    public boolean isPasswordValid(String rawPassword, String encodedPassword);
    public User updateUser(User user) throws ValidationException;
    public User findByEmail(String email) throws ValidationException;

    public boolean findByEmailAndPassword(String email, String password) throws ValidationException;

    public User findByID(Long id) throws ValidationException;

    public Long findIdByEmail(String email) throws ValidationException;

    public Boolean deleteUser(Long id) throws ValidationException;

}
