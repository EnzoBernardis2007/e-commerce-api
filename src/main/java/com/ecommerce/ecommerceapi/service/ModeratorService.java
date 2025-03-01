package com.ecommerce.ecommerceapi.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapi.dto.ModeratorRequestDTO;
import com.ecommerce.ecommerceapi.model.Moderator;
import com.ecommerce.ecommerceapi.repository.ModeratorRepository;

@Service
public class ModeratorService {
    
    @Autowired
    private ModeratorRepository moderatorRepository;

    public List<Moderator> listModerators() {
        return moderatorRepository.findAll();
    }

    public boolean createModerator(ModeratorRequestDTO moderatorRequestDTO) {
        try {
            Moderator moderator = new Moderator();
            moderator.setUuid(UUID.randomUUID());
            moderator.setEmail(moderatorRequestDTO.getEmail());
            moderator.setName(moderatorRequestDTO.getName());
            moderator.setPasswordSalt(generateSalt());
            moderator.setPasswordHash(generatePasswordHash(moderatorRequestDTO.getPassword(), moderator.getPasswordSalt()));
            moderatorRepository.save(moderator);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String generatePasswordHash(String password, byte[] passwordSalt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Use o algoritmo adequado
        byte[] hash = digest.digest((password + new String(passwordSalt)).getBytes());
        return java.util.Base64.getEncoder().encodeToString(hash); // Codifica o hash para salvar no banco
    }

    private byte[] generateSalt() {
        java.security.SecureRandom random = new java.security.SecureRandom();
        byte[] salt = new byte[16];  // Tamanho típico de salt
        random.nextBytes(salt);
        return salt;
    }
}
