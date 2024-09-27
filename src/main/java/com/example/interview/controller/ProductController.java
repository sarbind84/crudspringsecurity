package com.example.interview.controller;

import com.example.interview.domain.Products;
import com.example.interview.dto.ProductDto;
import com.example.interview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    //working1
    @GetMapping("/products")
    public ResponseEntity<ResponseData<Products>> getAll() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.CREATED);
    }

    //working1
    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseData<Products>> getAllId(@PathVariable int id) {
        productService.getByProductsId(id);
        return new ResponseEntity<>(productService.getByProductsId(id), HttpStatus.CREATED);
    }

    //working1
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        productService.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
    }

    //working
    @PutMapping("/products")
    public ResponseEntity<String> update(@RequestBody ProductDto productDto) {
        productService.update(productDto);
        return new ResponseEntity<>("Updated", HttpStatus.CREATED);
    }

    //working
    @PostMapping("/products")
    public ResponseData<String> add(@RequestBody List<ProductDto> productDtos) {
        return productService.save(productDtos);
    }


}
