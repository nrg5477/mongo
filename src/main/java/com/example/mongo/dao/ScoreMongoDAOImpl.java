package com.example.mongo.dao;

import com.example.mongo.dto.ScoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScoreMongoDAOImpl implements ScoreMongoDAO{
    private final MongoTemplate mongoTemplate;
    private final ScoreRepository repository;

    @Override
    public ScoreDTO findById(String value) {
        return repository.findById(value).get();
    }

    @Override
    public List<ScoreDTO> findCriteria(String key, String value) {
//        System.out.println(key + "=" + value);
//        Criteria criteria = new Criteria(key);
//        criteria.is(value);
        String[] data = key.split(",");
//        Criteria criteria = new Criteria(data[0]);
//        if (data[1].equals("is")) {
//            criteria.is(value);
//        } else if (data[1].equals("gt")) {
//            criteria.gt(Integer.parseInt(value));
//        } else if (data[1].equals("lt")) {
//            criteria.lt(Integer.parseInt(value));
//        }

        //where
//        Query query = new Query();
//        query.addCriteria(Criteria.where(data[0]).gte(Integer.parseInt(value)));

        //정규 표현식
        Criteria criteria = new Criteria(data[0]);
//        criteria.regex("^" + value);
        criteria.regex(".*" + value + ".*");
        Query query = new Query(criteria);

        List<ScoreDTO> list = mongoTemplate.find(query, ScoreDTO.class, "score");
//        System.out.println(list);
        return list;
    }

    @Override
    public ScoreDTO findById(String key, String value) {
        //id로 조회할 수 있도록 작업
        Query query = new Query(Criteria.where(key).is(value));
        return mongoTemplate.findOne(query, ScoreDTO.class, "score");
    }

    @Override
    public void insertDocument(ScoreDTO doc) {

    }

    @Override
    public void insertAllDocument(List<ScoreDTO> docs) {

    }

    @Override
    public void update(ScoreDTO document) {
        Criteria criteria = new Criteria("id");
        criteria.is(document.getId());
        Query query = new Query(criteria);

        Update update = new Update();
        update.set("dept", document.getDept());
        update.set("addr", document.getAddr());
        mongoTemplate.updateMulti(query, update, "score");
    }

    @Override
    public void test1() {

    }

    @Override
    public List<ScoreDTO> findAll() {
        List<ScoreDTO> list = mongoTemplate.findAll(ScoreDTO.class, "score");
        return list;
    }

    @Override
    public List<ScoreDTO> findAll(int pageNo) {
        return List.of();
    }
}
