package com.microservice.developer.repository;

import com.microservice.developer.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepo extends MongoRepository<Developer,Integer> {
    List<Developer> findByManagerId(Integer Id);
}
