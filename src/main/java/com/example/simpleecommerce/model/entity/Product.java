package com.example.simpleecommerce.model.entity;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Enabled
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
