package com.picpay.outbox.demo.producer;

import com.picpay.outbox.demo.model.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMessageProducer {

    private final StreamBridge bridge;

    public void sendEvent(UserEvent event){
        bridge.send("user-event-queue", MessageBuilder.withPayload(event).build());
    }
}
