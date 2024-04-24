package com.example.simpleecommerce.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
//@Builder
public class Response<T> {

    private String message;
    private T result;
    private List<T> errors;
    private Map<String, String> errorMap;
    private String error;
}
