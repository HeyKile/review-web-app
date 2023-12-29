package com.heykile.reviewgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
