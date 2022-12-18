package com.user.user.service;

import com.user.user.message.UserSendMessage;
import com.user.user.model.Action;
import com.user.user.model.Card;
import com.user.user.model.Quadro;
import com.user.user.model.User;
import com.user.user.openfeign.CardFeign;
import com.user.user.openfeign.QuadroFeign;
import com.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSendMessage userSendMessage;

    @Autowired
    private CardFeign cardFeign;

    @Autowired
    private QuadroFeign quadroFeign;

    public User create(User user) {
        userSendMessage.sendMessage(user, Action.ADD);
        return userRepository.save(user);
    }

    public User find(String id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User update(User user) {
        if (user.getId() != null) {
            if (user.getEmail() != null) {
                user.setEmail(user.getEmail());
            }
            if (user.getName() != null) {
                user.setName(user.getName());
            }
            if (user.getQuadro() != null) {
                user.setQuadro(user.getQuadro());
            }
            if (user.getQuadro() == null) {
                user.setQuadro(null);
            }
            userSendMessage.sendMessage(user, Action.UPDATE);
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var user = find(id);
            userRepository.delete(user);
            userSendMessage.sendMessage(user, Action.REMOVE);
        }
    }

    public User criarQuadro(Quadro quadro, String id) {
        if (id != null) {
            var qd = quadroFeign.create(quadro);
            var user = userRepository.findById(id).get();
            user.setQuadro(qd);
            return update(user);
        }
        return null;
    }

    public User atualizarQuadro(Quadro quadro, String id) {
        if (id != null) {
            quadroFeign.update(quadro);
            var user = userRepository.findById(id).get();
            user.getQuadro().setName(quadro.getName());
            return userRepository.save(user);
        }
        return null;
    }

    public User deleteQuadro(Quadro quadro, String id) {
        if (id != null) {
            quadroFeign.delete(quadro.getId());
            cardFeign.deleteAll(id);
            var user = userRepository.findById(id).get();
            user.setQuadro(null);
            return update(user);
        }
        return null;
    }

    public User criarCard(Card card, String id) {
        if (id != null) {
            card.setStatus("PENDENTE");
            card.setCriador(id);
            var user = find(id);
            card.setQuadro(user.getQuadro());
            var cd = cardFeign.create(card);
            user.getQuadro().getCardList().add(cd);
            return update(user);
        }
        return null;
    }

    public User updateCard(Card card, String id) {
        if (id != null) {
            var user = find(id);
            card.setCriador(id);
            card.setStatus("PENDENTE");
            card.setQuadro(user.getQuadro());
            cardFeign.update(card);
            var cards = cardFeign.findByCriador(id);
            user.getQuadro().setCardList(cards);
            return update(user);
        }
        return null;
    }

    public User moverCardDeFila(Card card, String id) {
        if (id != null) {
            var user = find(id);
            card.setStatus("FINALIZADO");
            cardFeign.updateStatus(card);
            var cards = cardFeign.findByCriador(id);
            user.getQuadro().setCardList(cards);
            return update(user);
        }
        return null;
    }

    public User deleteCard(Card card, String id) {
        if (id != null) {
            var user = find(id);
            cardFeign.delete(card.getId());
            var cards = cardFeign.findByCriador(id);
            user.getQuadro().setCardList(cards);
            return update(user);
        }
        return null;
    }
}
