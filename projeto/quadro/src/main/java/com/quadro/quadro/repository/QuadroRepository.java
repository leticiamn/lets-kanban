package com.quadro.quadro.repository;

import com.quadro.quadro.model.Quadro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadroRepository extends MongoRepository<Quadro, String> {
}
