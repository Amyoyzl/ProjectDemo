package com.amy.dom.message;

import com.amy.dom.exception.MessageException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender<T> {

    private final AmqpTemplate rabbitTemplate;

    public Sender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send (String queueName, T payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(payload);
            rabbitTemplate.convertAndSend(queueName, message);
        } catch (JsonProcessingException e) {
            log.error("Send message failed: {}", payload);
            throw new MessageException(payload.toString(), e);
        }
    }

    public void publish (String exchange, T payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(payload);
            rabbitTemplate.convertAndSend(exchange, "", message);
        } catch (JsonProcessingException e) {
            log.error("Send message failed: {}", payload);
            throw new MessageException(payload.toString(), e);
        }
    }

}
