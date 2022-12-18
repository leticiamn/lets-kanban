package com.card.card.repository;

import com.card.card.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {
    @Query("{criador: ?0}")
    public List<Card> findByCriador(String id);
}
