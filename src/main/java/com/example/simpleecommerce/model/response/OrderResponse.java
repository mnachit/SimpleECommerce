package com.example.simpleecommerce.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private int quantity;
    private double totalPrice;
    private UserResponse user;
}
