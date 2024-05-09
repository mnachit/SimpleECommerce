package com.example.simpleecommerce.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    @NonNull
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NonNull
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @NonNull
    private Double price;
    @NonNull
    @NotBlank(message = "User Id cannot be empty")
    private Long userId;
}
