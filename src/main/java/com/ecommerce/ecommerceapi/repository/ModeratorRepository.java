package com.ecommerce.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecommerce.ecommerceapi.model.Moderator;

@RepositoryRestResource
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    
}
