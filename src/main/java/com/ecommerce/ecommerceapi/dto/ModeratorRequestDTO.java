package com.ecommerce.ecommerceapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeratorRequestDTO {
    private String email;
    private String name;
    private String password;
}
