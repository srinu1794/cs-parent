package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.bean.GiftCardCatalog;

public interface MongoRepoGifts extends MongoRepository<GiftCardCatalog, String>{

}
