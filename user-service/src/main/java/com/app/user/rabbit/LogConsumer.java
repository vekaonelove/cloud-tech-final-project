package com.app.user.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {

    @RabbitListener(queues = "log.queue")
    public void receiveLog(String message) {
        System.out.println(" Received log message: " + message);
    }
}
