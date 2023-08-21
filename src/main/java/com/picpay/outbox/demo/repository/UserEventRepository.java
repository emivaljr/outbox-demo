package com.picpay.outbox.demo.repository;

import com.picpay.outbox.demo.model.UserEvent;
import com.picpay.outbox.demo.model.entity.UserEventEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserEventRepository extends CrudRepository<UserEventEntity,Long>{

}
