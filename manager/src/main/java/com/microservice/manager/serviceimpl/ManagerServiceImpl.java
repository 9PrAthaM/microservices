package com.microservice.manager.serviceimpl;

import com.microservice.manager.exception.BaseException;
import com.microservice.manager.model.Developers;
import com.microservice.manager.model.Manager;
import com.microservice.manager.repository.ManagerRepo;
import com.microservice.manager.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(ManagerServiceImpl.class);
    @Override
    public Manager  createManager(Manager manager) {
        Manager newManager=new Manager();
        newManager.setName(manager.getName());
        Manager save = managerRepo.save(newManager);
        return save;
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> allManager = managerRepo.findAll();
        return allManager;
    }

    @Override
    public Manager getManagerById(Integer id) throws BaseException {
        Manager manager = managerRepo.findById(id).orElseThrow(() -> new BaseException(601, "id is not present"));
        return manager;
    }

    @Override
    public Manager getDevelopersUnderManager(Integer id) throws BaseException {
        Manager manager = managerRepo.findById(id).orElseThrow(() -> new BaseException(601, "id is not present"));
        if(!ObjectUtils.isEmpty(manager.getId())){
            ArrayList<Developers> arrayList = restTemplate.postForObject(
                    "http://Developer-Service/developer/developersManager/" + manager.getId(),
                    null,
                    ArrayList.class);
            logger.info("developerList:--{}",arrayList);
            manager.setDevelopersList(arrayList);
        }
        return manager;
    }
}
