package com.picpay.outbox.demo.model.entity;

import com.picpay.outbox.demo.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    
    @Id
    private  UUID id;

    private  String name;

    private LocalDate birth;

    public static UserEntity fromModel(User user){
        return new UserEntity(UUID.randomUUID(),user.getName(),user.getBirth());
    }
    
}
