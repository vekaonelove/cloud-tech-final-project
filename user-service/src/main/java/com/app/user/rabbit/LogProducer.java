package com.app.user.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${log.exchange.name:log.exchange}")
    private String exchangeName;

    @Value("${log.routing.key:log.routingKey}")
    private String routingKey;

    public LogProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendLog(String message) {
        System.out.println("📤 Sending log message: " + message);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
