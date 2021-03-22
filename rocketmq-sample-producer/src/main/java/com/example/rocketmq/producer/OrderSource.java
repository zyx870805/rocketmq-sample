package com.example.rocketmq.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderSource {

    String OUTPUT = "orderOutput";

    @Output(OrderSource.OUTPUT)
    MessageChannel output();
}
