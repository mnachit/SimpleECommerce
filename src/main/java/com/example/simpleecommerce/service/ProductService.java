package com.example.simpleecommerce.service;

import com.example.simpleecommerce.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public void saveProduct(Product product);
    public List<Product> getAllProduct();
    public void deleteProduct(Long id);
    public Product findById(Long id);
}
