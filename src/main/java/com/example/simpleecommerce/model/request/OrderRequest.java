package com.example.simpleecommerce.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long productId;
    private Long userId;
    private int quantity;
}
