package com.ecommerce.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceapi.dto.ProductRequestDTO;
import com.ecommerce.ecommerceapi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> listProducts () {
        try {
            return ResponseEntity.status(200).body(productService.listProducts());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("error");
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO product) {
        if(productService.createProduct(product)) {
            return ResponseEntity.status(200).body(product);
        }

        return ResponseEntity.status(500).body("error");
    }
}
