package com.example.simpleecommerce.controller;

import com.example.simpleecommerce.model.entity.Order;
import com.example.simpleecommerce.model.entity.Product;
import com.example.simpleecommerce.model.entity.User;
import com.example.simpleecommerce.model.mapper.OrderMapper;
import com.example.simpleecommerce.model.request.OrderRequest;
import com.example.simpleecommerce.model.response.ErrorRes;
import com.example.simpleecommerce.service.OrderService;
import com.example.simpleecommerce.service.ProductService;
import com.example.simpleecommerce.service.UserService;
import com.example.simpleecommerce.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {
    private OrderService orderService;
    private ProductService productService;
    private UserService userService;

    @PostMapping("/rest/order/new")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest)
    {
        Response<String> orderDtoResponseResponse = new Response<>();
        try {
            User user = userService.findByID(orderRequest.getUserId());
            Product product = productService.findById(orderRequest.getProductId());
            Order order = OrderMapper.OrderRequestToEntity(orderRequest,user,product);
            orderService.saveOrder(order);
            orderDtoResponseResponse.setMessage("Order has been added");
            return ResponseEntity.ok(orderDtoResponseResponse);
        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid order");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
