package com.amy.payment.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Receiver {

    /**
     * simple
     * @param message
     */
    @RabbitListener(queues = "demo.book.update")
    public void simpleReceiveMessage(Message message){
        log.info("message type: " + message.getMessageProperties().getDeliveryTag());
        log.info("receive message from queue[demo.book.update], content: {}", message);
    }

    /**
     * work queue
     * @param message
     */
    @RabbitListener(queues = "demo.book.update.work")
    public void workQueueConsumer1(Message message) throws InterruptedException {
        Thread.sleep(1000);
        log.info("consumer1 receive message from queue[demo.book.update.work], content: {}", message);
    }

    /**
     * work queue
     * @param message
     */
    @RabbitListener(queues = "demo.book.update.work")
    public void workQueueConsumer2(Message message) throws InterruptedException {
        Thread.sleep(1000);
        log.info("consumer2 receive message from queue[demo.book.update.work], content: {}", message);
    }

    /**
     * Publish/Subscribe
     * @param message
     */
    @RabbitListener(queues = "demo.book.update.publish1")
    public void subscribe1(Message message) {
        log.info("subscribe1 receive message from queue[demo.book.update.publish1], content: {}", message);
    }

    /**
     * Publish/Subscribe
     * @param message
     */
    @RabbitListener(queues = "demo.book.update.publish2")
    public void subscribe2(Message message) {
        log.info("subscribe2 receive message from queue[demo.book.update.publish2], content: {}", message);
    }

}
