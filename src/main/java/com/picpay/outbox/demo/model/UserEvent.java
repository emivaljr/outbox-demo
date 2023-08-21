package com.picpay.outbox.demo.model;

import com.picpay.outbox.demo.model.entity.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class UserEvent {

    private UUID id;

    private EventType type;

    private User user;
}
