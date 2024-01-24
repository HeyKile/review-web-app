package com.heykile.reviewgame.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Term {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String word;
    private String definition;

    public Term() {
    }

    public Term (String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public void setWord (String word) {
        this.word = word;
    }

    public void setDefinition (String definition) {
        this.definition = definition;
    }

    public String getWord () {
        return this.word;
    }

    public String getDefinition () {
        return this.definition;
    }

}
