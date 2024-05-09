package com.example.simpleecommerce.model.mapper;


import com.example.simpleecommerce.model.entity.Order;
import com.example.simpleecommerce.model.entity.Product;
import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.request.OrderRequest;
import com.example.simpleecommerce.model.response.OrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static List<OrderResponse> mapOrderToOrderResponse(List<Order> order) {
        List<OrderResponse> responses = new ArrayList<>();

        for (Order o : order) {
            OrderResponse response = new OrderResponse();
            response.setId(o.getId());
            response.setQuantity(o.getQuantity());
            response.setTotalPrice(o.getTotalPrice());
            response.setUser(UserMapper.UserToUserResponse(o.getUser()));
            responses.add(response);
        }
        return responses;
    }

    public static Order OrderRequestToEntity(OrderRequest orderRequest, User user, Product product) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalPrice(product.getPrice() * orderRequest.getQuantity());
        return order;
    }
}
