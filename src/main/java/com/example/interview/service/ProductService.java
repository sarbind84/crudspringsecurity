package com.example.interview.service;

import com.example.interview.controller.ResponseData;
import com.example.interview.domain.Products;
import com.example.interview.dto.ProductDto;
import com.example.interview.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public ResponseData<Products> getAllProducts() {
        List<Products> products = null;
        ResponseData<Products> objectResponseData = new ResponseData<>(products);

        try {
            products = productRepository.findAll();
            objectResponseData.setData(products);
            objectResponseData.setCode(201);
            objectResponseData.setMessage("Successful Operation");
            return objectResponseData;
        } catch (Exception e) {
            objectResponseData.setCode(400);
            objectResponseData.setMessage(e.getMessage());
            return objectResponseData;
        }

    }


    //getbyid
    public ResponseData<Products> getByProductsId(long id) {

        Products products = null;
        ResponseData<Products> objectResponseData = new ResponseData<>((List<Products>) products);
        try {
            productRepository.findById(id).ifPresent(e -> objectResponseData.setData(Collections.singletonList(e)));
            objectResponseData.setMessage("Successful Operation");
            objectResponseData.setCode(201);
            return objectResponseData;
        } catch (Exception e) {
            objectResponseData.setData(null);
            objectResponseData.setMessage(e.getMessage());
            objectResponseData.setCode(400);
            return objectResponseData;

        }
    }

    //save
    public ResponseData<String> save(List<ProductDto> productDtos) {

        try {
            for (ProductDto p : productDtos) {
                Products products1 = new Products();
                products1.setCategory(p.getCategory());
                products1.setName(p.getName());
                products1.setDesc(p.getDescription());
                products1.setPrice(p.getPrice());
                productRepository.save(products1);
                return new ResponseData<>(201, "Created");
            }
        } catch (Exception e) {
            return new ResponseData<>(401, e.getMessage());
        }

        return null;
    }

    //update
    public ResponseData<Products> update(ProductDto products) {
        try {
            Products productById = productRepository.findById(products.getId()).get();
            productById.setDesc(products.getDescription());
            productById.setPrice(products.getPrice());
            productById.setName(products.getName());
            productById.setCategory(products.getCategory());
            Products save = productRepository.save(productById);
            return new ResponseData<>(201, "Updated", Collections.singletonList(save));
        } catch (Exception e) {
            return new ResponseData<>(401, e.getMessage());
        }
    }

    public ResponseData<String> deleteById(long id) {
        try {
            productRepository.deleteById(id);
            return new ResponseData<>(201, "Created");
        } catch (Exception e) {
            return new ResponseData<>(401, e.getMessage());
        }
    }


}
