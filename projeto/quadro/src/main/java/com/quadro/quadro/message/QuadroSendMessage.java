package com.quadro.quadro.message;

import com.quadro.quadro.model.Action;
import com.quadro.quadro.model.Log;
import com.quadro.quadro.model.Quadro;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuadroSendMessage {
    @Value("${quadro.rabbitmq.exchange}")
    String exchange;

    @Value("${quadro.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Quadro quadro, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setQuadroName(quadro.getName());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}
