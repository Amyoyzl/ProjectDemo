package com.amy.payment.message;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;


@Component
@Slf4j
public class SimpleReceive {

    @RabbitListener(queues = "demo.book.update")
    public void simpleReceiveMessage(Message message){
        log.info("message type: " + message.getMessageProperties().getDeliveryTag());
        log.info("receive message from queue[demo.book.update], content: {}", message);
    }
}
