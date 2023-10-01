package com.microservice.manager.service;

import com.microservice.manager.exception.BaseException;
import com.microservice.manager.model.Manager;

import java.util.List;

public interface ManagerService {
    Manager createManager( Manager manager);
    List<Manager> getAllManagers();
    Manager getManagerById(Integer id) throws BaseException;
}
