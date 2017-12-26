package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.bean.ProductCatalog;

public interface MongoRepo extends MongoRepository<ProductCatalog, String>{

}
