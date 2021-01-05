package com.amy.payment.message;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class SimpleReceive {

    @RabbitListener(queues = "demo.book.update")
    public void simpleReceiveMessage() {

    }
}
