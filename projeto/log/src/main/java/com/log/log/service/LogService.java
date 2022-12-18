package com.log.log.service;

import com.log.log.model.Action;
import com.log.log.model.Log;
import com.log.log.model.User;
import com.log.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log createLogUser(Log log){
        return logRepository.save(log);
    }

    public Log createLogQuadro(Log log){
        return logRepository.save(log);
    }

    public Log createLogCard(Log log){
        return logRepository.save(log);
    }

    public Log find(String id){
        return logRepository.findById(id).get();
    }

    public List<Log> findAll(){
        return logRepository.findAll();
    }

    public List<Action> findByAction(Action action) {
        return logRepository.findByAction(action.toString());
    }

    public List<User> findByUser(String userName) {
        return logRepository.findByUser(userName);
    }

    public List<Log> findLogByDataLog(String dataLog) {
        return logRepository.findLogByDataLog(dataLog);
    }

    public List<Log> findLogByCardStatus(String cardStatus) {
        return logRepository.findLogByCardStatus(cardStatus);
    }
}
