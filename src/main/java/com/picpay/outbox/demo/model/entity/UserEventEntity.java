package com.picpay.outbox.demo.model.entity;

import com.picpay.outbox.demo.model.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class UserEventEntity {
    
    @Id
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private EventType type;

    @ManyToOne
    private UserEntity user;

    public static UserEventEntity newEventEntity(UserEntity userEntity) {
        return new UserEventEntity(UUID.randomUUID(),EventType.USER_WAS_CREATED,userEntity);
    }
}
