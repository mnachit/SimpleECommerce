package com.example.simpleecommerce.repository;

import com.example.simpleecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
