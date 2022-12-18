package com.card.card.service;

import com.card.card.message.CardSendMessage;
import com.card.card.model.Action;
import com.card.card.model.Card;
import com.card.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardSendMessage cardSendMessage;

    public Card create(Card card) {
        cardSendMessage.sendMessage(card, Action.ADD);
        return cardRepository.save(card);
    }

    public Card find(String id) {
        return cardRepository.findById(id).get();
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public List<Card> findByCriador(String id){
        return cardRepository.findByCriador(id);
    }

    public Card update(Card card) {
        if (card.getId() != null) {
            var cd = find(card.getId());
            cd.setTitulo(card.getTitulo());
            cd.setDescricao(card.getDescricao());
            cd.setDataCriacao(card.getDataCriacao());
            cd.setCriador(card.getCriador());
            cd.setStatus(card.getStatus());
            cardSendMessage.sendMessage(cd, Action.UPDATE);
            return cardRepository.save(cd);
        }
        return null;
    }

    public Card updateStatus(Card card) {
        if (card.getId() != null) {
            var cd = find(card.getId());
            cd.setStatus(card.getStatus());
            cardSendMessage.sendMessage(cd, Action.UPDATE);
            return cardRepository.save(cd);
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var cd = find(id);
            cardSendMessage.sendMessage(cd, Action.REMOVE);
            cardRepository.delete(cd);
        }
    }

    public void deleteAll(String id){
        if (id != null) {
            var cd = findAll();
            for (int i = 0; i < cd.size(); i++) {
                if(cd.get(i).getCriador()==id){
                    cardRepository.delete(cd.get(i));
                    cardSendMessage.sendMessage((Card) cd, Action.REMOVE);
                }
            }
        }
    }
}
