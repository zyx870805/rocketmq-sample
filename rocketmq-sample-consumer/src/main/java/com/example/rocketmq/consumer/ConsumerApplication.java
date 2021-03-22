package com.example.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding({Sink.class, InputChannel.class})
public class ConsumerApplication {

    @StreamListener(value = Sink.INPUT)
    public void receive(String receiveMsg) {
        System.out.println("TopicTest receive: " + receiveMsg + ", receiveTime = " + System.currentTimeMillis());
    }

    @StreamListener(value = InputChannel.ORDER_INPUT)
    public void receiveOrder(String receiveMsg) {
        System.out.println("receive: " + receiveMsg);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
