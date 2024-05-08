package com.example.simpleecommerce.model.mapper;

import com.example.simpleecommerce.model.entity.Product;
import com.example.simpleecommerce.model.request.ProductRequest;
import com.example.simpleecommerce.model.response.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product ProductRequestToEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    public static List<ProductResponse> ProductEntityToResponse(List<Product> products) {
        List<ProductResponse> responses = new ArrayList<>();

        for (Product product : products) {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setOrders(OrderMapper.mapOrderToOrderResponse(product.getOrders()));
            responses.add(response);
        }

        return responses;
    }
}
