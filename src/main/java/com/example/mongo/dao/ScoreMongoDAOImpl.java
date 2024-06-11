package com.example.mongo.dao;

import com.example.mongo.dto.ScoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScoreMongoDAOImpl implements ScoreMongoDAO{
    private final MongoTemplate mongoTemplate;
    private final ScoreRepository repository;

    @Override
    public List<ScoreDTO> findCriteria(String key, String value) {
        System.out.println(key + "=" + value);
        Query query = new Query();
        mongoTemplate.find(null, ScoreDTO.class, "score");

        return List.of();
    }

    @Override
    public ScoreDTO findById(String key, String value) {
        return null;
    }

    @Override
    public void insertDocument(ScoreDTO doc) {

    }

    @Override
    public void insertAllDocument(List<ScoreDTO> docs) {

    }

    @Override
    public void update(ScoreDTO document) {

    }

    @Override
    public void test1() {

    }

    @Override
    public List<ScoreDTO> findAll() {
        return List.of();
    }

    @Override
    public List<ScoreDTO> findAll(int pageNo) {
        return List.of();
    }
}
