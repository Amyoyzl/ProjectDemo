package com.amy.payment.message;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class DirectReceive {

    @RabbitListener(queues = "")
    public void directReceiveMessage() {

    }
}
