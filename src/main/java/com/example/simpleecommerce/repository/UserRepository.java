package com.example.simpleecommerce.repository;

import com.example.simpleecommerce.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.id <> :excludeId")
    List<User> findAllUsersExceptId(Long excludeId);
}
