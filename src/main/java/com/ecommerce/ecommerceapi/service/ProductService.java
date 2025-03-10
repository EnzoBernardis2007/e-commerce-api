package com.ecommerce.ecommerceapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapi.dto.ProductRequestDTO;
import com.ecommerce.ecommerceapi.model.Product;
import com.ecommerce.ecommerceapi.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public boolean createProduct(ProductRequestDTO productRequestDTO) {
        try {
            Product product = new Product();
            product.setName(productRequestDTO.getName());
            product.setDescription(productRequestDTO.getDescription());
            product.setPrice(productRequestDTO.getPrice());
            product.setQuantity(productRequestDTO.getQuantity());
            product.setRegistration(LocalDateTime.now());
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
