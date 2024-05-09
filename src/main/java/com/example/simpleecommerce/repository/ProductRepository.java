package com.example.simpleecommerce.repository;

import com.example.simpleecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAllByUserId(Long id);
}
