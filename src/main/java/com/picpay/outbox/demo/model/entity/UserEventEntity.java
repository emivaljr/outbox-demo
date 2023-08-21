package com.picpay.outbox.demo.model.entity;

import com.picpay.outbox.demo.model.EventType;
import com.picpay.outbox.demo.model.UserEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;

    public static UserEventEntity newEventEntity(UserEntity userEntity) {
        return new UserEventEntity(UUID.randomUUID(),EventType.USER_WAS_CREATED,LocalDateTime.now(),userEntity);
    }
    public UserEvent toDomain(){
        return new UserEvent(this.id,this.type,this.user.toDomain());
    }
}
