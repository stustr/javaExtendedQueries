package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(@RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "distillery", required = false) String distillery, @RequestParam(name = "age", required = false) Integer age, @RequestParam(name="region", required = false) String region){

        if (year != null && distillery == null && age == null && region == null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);

        } else if (year == null && distillery != null && age != null && region == null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryNameAndAge(distillery, age), HttpStatus.OK);

        } else if (year == null && distillery == null && age == null && region != null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }

        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
