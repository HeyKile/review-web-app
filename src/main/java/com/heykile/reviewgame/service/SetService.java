package com.heykile.reviewgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heykile.reviewgame.repository.SetRepository;
import com.heykile.reviewgame.util.VocabSet;


@Service
public class SetService {
    
    private final SetRepository setRepository;

    @Autowired
    public SetService(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    public VocabSet createSet(VocabSet vocabSet) {
        return setRepository.save(vocabSet);
    }

}
