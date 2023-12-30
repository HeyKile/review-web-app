package com.heykile.reviewgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heykile.reviewgame.service.SetService;
import com.heykile.reviewgame.util.VocabSet;

@RestController
@RequestMapping("/api/endpoint")
public class SetController {

    @Autowired
    private SetService setService;
    
    @PostMapping("/api/endpoint")
    public ResponseEntity<VocabSet> createSet (@RequestBody VocabSet vocabSet){
        VocabSet createdSet = setService.createSet(vocabSet);
        System.out.println("Recieved set");
        return new ResponseEntity<>(createdSet, HttpStatus.CREATED);
    }
}
