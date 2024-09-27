package com.example.interview.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class ProductDto {

    long id;
    String name;
    String description;
    Double price;
    String category;
}
