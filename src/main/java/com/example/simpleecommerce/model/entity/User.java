package com.example.simpleecommerce.model.entity;

import com.example.simpleecommerce.model.enums.RoleUser;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Enabled
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;
}
