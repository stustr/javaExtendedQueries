package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleries(
            @RequestParam(name= "age", required=false) Integer age, @RequestParam(name = "region", required = false) String region){
        if (age != null && region == null){
            return new ResponseEntity<>(distilleryRepository.findDistilleryByWhiskiesAge(age), HttpStatus.OK);
        } else if (age == null && region != null) {
            return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(),
                HttpStatus.OK);
    }

}
