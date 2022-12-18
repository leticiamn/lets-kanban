package com.log.log.repository;

import com.log.log.model.Action;
import com.log.log.model.Log;
import com.log.log.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    @Query("{action: ?0}")
    public List<Action> findByAction(String action);

    @Query("{userName: ?0}")
    public List<User> findByUser(String userName);

    @Query("{dataLog: ?0}")
    public List<Log> findLogByDataLog(String dataLog);

    @Query("{cardStatus: ?0}")
    public List<Log> findLogByCardStatus(String cardStatus);
}
