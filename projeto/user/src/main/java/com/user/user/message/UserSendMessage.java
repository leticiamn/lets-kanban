package com.user.user.message;

import com.user.user.model.Action;
import com.user.user.model.Log;
import com.user.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSendMessage {
    @Value("${user.rabbitmq.exchange}")
    String exchange;

    @Value("${user.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(User user, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setUserName(user.getName());
        log.setUserEmail(user.getEmail());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}
