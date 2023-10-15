package com.microservice.developer.controller;

import com.microservice.developer.model.Developer;
import com.microservice.developer.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperContoller {
    @Autowired
    private DeveloperService developerService;
    @PostMapping("/create")
    public ResponseEntity<Developer> createNewDeveloper(@RequestBody Developer developer) {
        return  new ResponseEntity<>( developerService.createDeveloper(developer), HttpStatus.OK);
    }
    @GetMapping("/allDeveloper")
    public ResponseEntity<List<Developer>> getAllDeveloper(){
        return new ResponseEntity<>(developerService.getAllDeveloper(),HttpStatus.OK);
    }
    @PostMapping("/developersManager/{Id}")
    public ResponseEntity<List<Developer>> getDeveloperManager(@PathVariable("Id") Integer Id){
        return new ResponseEntity<>(developerService.getDeveloperbyManagerId(Id),HttpStatus.OK);
    }
}

