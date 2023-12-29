package com.heykile.reviewgame;

public class Term {
    
    private String word;
    private String definition;

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
