package com.quadro.quadro.service;

import com.quadro.quadro.message.QuadroSendMessage;
import com.quadro.quadro.model.Action;
import com.quadro.quadro.model.Quadro;
import com.quadro.quadro.repository.QuadroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadroService {
    @Autowired
    private QuadroRepository quadroRepository;

    @Autowired
    private QuadroSendMessage quadroSendMessage;

    public Quadro create(Quadro quadro) {
        quadroSendMessage.sendMessage(quadro, Action.ADD);
        return quadroRepository.save(quadro);
    }

    public Quadro find(String id) {
        return quadroRepository.findById(id).get();
    }

    public List<Quadro> findAll() {
        return quadroRepository.findAll();
    }

    public Quadro update(Quadro quadro) {
        if (quadro.getId() != null) {
            var qd = find(quadro.getId());
            qd.setName(quadro.getName());
            quadroSendMessage.sendMessage(qd, Action.UPDATE);
            return quadroRepository.save(qd);
        }
        return null;
    }

    public void delete(String id) {
        if (id != null) {
            var qd = find(id);
            quadroSendMessage.sendMessage(qd, Action.REMOVE);
            quadroRepository.delete(qd);
        }
    }
}
