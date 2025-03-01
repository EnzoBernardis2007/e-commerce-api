package com.ecommerce.ecommerceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceapi.dto.ModeratorRequestDTO;
import com.ecommerce.ecommerceapi.service.ModeratorService;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {

    @Autowired
    private ModeratorService moderatorService;
    
    @PostMapping
    public ResponseEntity<?> createModerator(@RequestBody ModeratorRequestDTO moderator) {
        System.out.println(moderator);
        if(moderatorService.createModerator(moderator)) {
            
            return ResponseEntity.status(200).body(moderator);
        } 

        return ResponseEntity.status(500).body("error");
    }
    
}
