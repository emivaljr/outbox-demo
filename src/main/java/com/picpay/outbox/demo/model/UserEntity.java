package com.picpay.outbox.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;


@Entity
public class UserEntity {
    
    @Id
    private UUID id;
    
}
