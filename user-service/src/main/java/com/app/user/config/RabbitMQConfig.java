package com.app.user.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "log.queue";
    public static final String EXCHANGE_NAME = "log.exchange";
    public static final String ROUTING_KEY = "log.routingKey";

    @Bean
    public Queue logQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange logExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding logBinding(Queue logQueue, DirectExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange).with(ROUTING_KEY);
    }
}
