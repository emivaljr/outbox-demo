package com.picpay.outbox.demo.repository;

import com.picpay.outbox.demo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long>{

    
}
