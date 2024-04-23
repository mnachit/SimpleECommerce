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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;
}
