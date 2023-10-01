package com.microservice.manager.controller;

import com.microservice.manager.exception.BaseException;
import com.microservice.manager.model.Manager;
import com.microservice.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @PostMapping("/create")
    public ResponseEntity<Manager> createNewManager(@RequestBody Manager manager){
        Manager newManager = managerService.createManager(manager);
        return new ResponseEntity<>(newManager, HttpStatus.OK);
    }
    @GetMapping("/getManager")
    public ResponseEntity<List<Manager>>getManager(){
        List<Manager> allManagers = managerService.getAllManagers();
        return new ResponseEntity<>(allManagers,HttpStatus.OK);

    }
    @GetMapping("/getManagerByid/{id}")
    public ResponseEntity<Manager>getById(@PathVariable("id") Integer id) throws BaseException {
        Manager managerById = managerService.getManagerById(id);
        return new ResponseEntity<>(managerById,HttpStatus.OK);
    }

}
