package com.example.simpleecommerce.service.impl;

import com.example.simpleecommerce.model.entity.Product;
import com.example.simpleecommerce.repository.ProductRepository;
import com.example.simpleecommerce.service.ProductService;
import com.example.simpleecommerce.util.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        if (productRepository.findById(id).isEmpty())
            errorMessages.add(ErrorMessage.builder().message("Product not found").build());
        if (errorMessages.size() > 0)
            throw new RuntimeException("Product not found");
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
