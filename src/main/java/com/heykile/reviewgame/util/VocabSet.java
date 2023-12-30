package com.heykile.reviewgame.util;

import java.util.List;

public class VocabSet {
    
    private String setName;
    private String setCategory;
    private List<Term> terms;

    public VocabSet (String name, String category, List<Term> terms) {
        this.setName = name;
        this.setCategory = category;
        this.terms = terms;
    }

    public void setName (String name) {
        this.setName = name;
    }

    public void setCategory (String category) {
        this.setCategory = category;
    }

    public String getName () {
        return this.setName;
    }

    public String getCategory () {
        return this.setCategory;
    }

    public List<Term> getTerms () {
        return this.terms;
    }

    public void addTerm (Term term) {
        terms.add(term);
    }

    public boolean removeTerm (Term term) {
        return terms.remove(term);
    }

}
