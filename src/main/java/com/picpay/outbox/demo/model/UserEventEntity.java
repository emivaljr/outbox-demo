package com.picpay.outbox.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;



@Entity
public class UserEventEntity {
    
    @Id
    private UUID id;

}
