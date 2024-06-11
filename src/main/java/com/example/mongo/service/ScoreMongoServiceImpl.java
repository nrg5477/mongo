package com.example.mongo.service;

import com.example.mongo.dto.ScoreDTO;

import java.util.List;

public class ScoreMongoServiceImpl implements ScoreMongoService{
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
    public List<ScoreDTO> findCriteria(String key, String value) {
        return dao.findCriteria(key, value);
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
