package com.example.simpleecommerce.service;

import com.example.simpleecommerce.model.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void saveOrder(Order order);
}
