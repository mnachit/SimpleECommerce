package com.example.simpleecommerce.model.entity;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
