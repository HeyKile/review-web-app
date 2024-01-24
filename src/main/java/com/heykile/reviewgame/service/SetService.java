package com.heykile.reviewgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heykile.reviewgame.Model.VocabSet;
import com.heykile.reviewgame.repository.SetRepository;


@Service
public class SetService {
    
    private final SetRepository setRepository;

    @Autowired
    public SetService (SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    public VocabSet createSet (VocabSet vocabSet) {
        return setRepository.save(vocabSet);
    }

    public VocabSet retrieveSet (String userId) {
        long id = Long.parseLong(userId);
        return setRepository.findById(id).orElse(null);
    }

    public List<VocabSet> retrieveUserSets (String userId) {
        return setRepository.findByUserId(userId); // TODO: idk if this works or not
    }

}
