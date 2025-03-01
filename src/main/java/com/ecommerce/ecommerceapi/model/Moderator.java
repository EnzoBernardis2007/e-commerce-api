package com.ecommerce.ecommerceapi.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "moderators")
@Getter
@Setter
@AllArgsConstructor
public class Moderator {

    public Moderator() { }

    @Id
    @Column(name = "uuid")
    public UUID uuid;
    @Column(name = "email")
    public String email;
    @Column(name = "name")
    public String name;
    @Column(name = "passwordhash")
    public String passwordHash;
    @Column(name = "passwordsalt")
    public byte[] passwordSalt;
}
