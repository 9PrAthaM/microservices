package com.microservice.manager.serviceimpl;

import com.microservice.manager.exception.BaseException;
import com.microservice.manager.model.Manager;
import com.microservice.manager.repository.ManagerRepo;
import com.microservice.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepo managerRepo;
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
}
