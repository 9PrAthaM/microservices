package com.microservice.developer.serviceImpl;

import com.microservice.developer.model.Developer;
import com.microservice.developer.repository.DeveloperRepo;
import com.microservice.developer.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperRepo developerRepo;

    @Override
    public Developer createDeveloper(Developer developer) {
        return developerRepo.save(developer);
    }

    @Override
    public List<Developer> getAllDeveloper() {
        return developerRepo.findAll();
    }

    @Override
    public List<Developer> getDeveloperbyManagerId(Integer id) {
        return !developerRepo.findByManagerId(id).isEmpty() ? developerRepo.findByManagerId(id) : new ArrayList<>();
    }
}
