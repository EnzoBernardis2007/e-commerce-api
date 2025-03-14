package com.ecommerce.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecommerce.ecommerceapi.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
