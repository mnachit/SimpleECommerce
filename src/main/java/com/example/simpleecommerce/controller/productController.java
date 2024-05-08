package com.example.simpleecommerce.controller;

import com.example.simpleecommerce.model.entity.Product;
import com.example.simpleecommerce.model.mapper.ProductMapper;
import com.example.simpleecommerce.model.request.ProductRequest;
import com.example.simpleecommerce.model.response.ErrorRes;
import com.example.simpleecommerce.model.response.ProductResponse;
import com.example.simpleecommerce.service.ProductService;
import com.example.simpleecommerce.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/api/v1")
public class productController {
    private ProductService productService;

    @PostMapping("/rest/product/new")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest)
    {
        Response<String> productDtoResponseResponse = new Response<>();
        try {
            Product product = ProductMapper.ProductRequestToEntity(productRequest);
            productService.saveProduct(product);
            productDtoResponseResponse.setMessage("Product has been added");
            return ResponseEntity.ok(productDtoResponseResponse);
        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid product");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/rest/product/all")
    public ResponseEntity<?> getAllProduct() {
        Response<List<ProductResponse>> productDtoResponseResponse = new Response<>();
        try {
            productDtoResponseResponse.setResult(ProductMapper.ProductEntityToResponse(productService.getAllProduct()));
            return ResponseEntity.ok(productDtoResponseResponse);
        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid product");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/rest/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Response<String> productDtoResponseResponse = new Response<>();
        try {
            productService.deleteProduct(id);
            productDtoResponseResponse.setMessage("Product has been deleted");
            return ResponseEntity.ok(productDtoResponseResponse);
        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid product");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/rest/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Response<Product> productDtoResponseResponse = new Response<>();
        try {
            productDtoResponseResponse.setResult(productService.findById(id));
            return ResponseEntity.ok(productDtoResponseResponse);
        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid product");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/rest/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id)
    {
        Response<String> productDtoResponseResponse = new Response<>();
        try {
            Product product = ProductMapper.ProductRequestToEntity(productRequest);
            product.setId(id);
            productService.saveProduct(product);
            productDtoResponseResponse.setMessage("Product has been updated");
            return ResponseEntity.ok(productDtoResponseResponse);
        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid product");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
