package com.microservice.developer.service;

import com.microservice.developer.model.Developer;

import java.util.List;

public interface DeveloperService {
    Developer createDeveloper(Developer developer);
    List<Developer> getAllDeveloper();
    List<Developer> getDeveloperbyManagerId(Integer Id);
}
