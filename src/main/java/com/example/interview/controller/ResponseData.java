package com.example.interview.controller;

import com.example.interview.domain.Products;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    int code;
    String message;

    List<T> data;

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(List<Products> products) {

    }

    public ResponseData(int code, String message, List<T> data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }
}
