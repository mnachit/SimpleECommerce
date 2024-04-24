package com.example.simpleecommerce.repository;

import com.example.simpleecommerce.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
