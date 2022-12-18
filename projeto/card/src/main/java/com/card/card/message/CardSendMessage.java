package com.card.card.message;

import com.card.card.model.Action;
import com.card.card.model.Card;
import com.card.card.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CardSendMessage {
    @Value("${card.rabbitmq.exchange}")
    String exchange;

    @Value("${card.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Card card, Action action) {
        Log log = new Log();
        log.setAction(action);
        log.setDataLog(log.getDataLog());
        log.setCardTitulo(card.getTitulo());
        log.setCardCriador(card.getCriador());
        log.setCardStatus(card.getStatus());
        log.setCardDescricao(card.getDescricao());
        log.setCardDescricao(card.getDataCriacao().toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}
