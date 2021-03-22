package com.example.rocketmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.annotation.Order;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    private Source source;

    @Autowired
    private OrderSource orderSource;
    
    @GetMapping(value = "/send")
    public String send(String msg) {
        MessageBuilder builder = MessageBuilder.withPayload(msg);
        Message message = builder.build();
        source.output().send(message);
        orderSource.output().send(message);
        return "Hello RocketMQ Binder, send " + msg;
    }
}