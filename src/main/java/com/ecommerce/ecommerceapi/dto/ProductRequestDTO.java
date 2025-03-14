package com.ecommerce.ecommerceapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime resgistration;
}
