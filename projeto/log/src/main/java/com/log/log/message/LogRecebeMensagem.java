package com.log.log.message;

import com.log.log.model.Log;
import com.log.log.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LogRecebeMensagem {
    @Autowired
    private LogService logService;

    @RabbitListener(queues = {"${user.rabbitmq.queue}"})
    public void receiveUser(@Payload Log user) {
        logService.createLogUser(user);
    }

    @RabbitListener(queues = {"${quadro.rabbitmq.queue}"})
    public void receiveQuadro(@Payload Log quadro) {
        logService.createLogQuadro(quadro);
    }

    @RabbitListener(queues = {"${card.rabbitmq.queue}"})
    public void receiveCard(@Payload Log card) {
        logService.createLogCard(card);
    }
}
