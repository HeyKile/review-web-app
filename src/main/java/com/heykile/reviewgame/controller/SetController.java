package com.heykile.reviewgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heykile.reviewgame.Model.VocabSet;
import com.heykile.reviewgame.service.SetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/set")
public class SetController {

    @Autowired
    private SetService setService;

    @GetMapping("/set/retrieve")
    public VocabSet retrieveSet (@RequestParam String userId) {
        return setService.retrieveSet(userId);
    }
    
    @GetMapping("/set/retrieveAll")
    public List<VocabSet> retrieveUserSets(@RequestParam String userId) {
        return setService.retrieveUserSets(userId); // TODO: fix json formatting
    }
    
    @PostMapping("/set/create")
    public ResponseEntity<VocabSet> createSet (@RequestBody VocabSet vocabSet){
        VocabSet createdSet = setService.createSet(vocabSet);
        System.out.println("Recieved set");
        return new ResponseEntity<>(createdSet, HttpStatus.CREATED);
    }
}
