package com.heykile.reviewgame.Model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;

@Entity
public class VocabSet {
    @Id
    @GeneratedValue(strategy = GenerationType.INDENTITY)
    private long id;
    
    @Column(name = "user_id")
    private String userId;

    public VocabSet (String userId, String name, String category, List<Term> terms) {
        this.userId = userId;
        this.setName = name;
        this.setCategory = category;
        this.terms = terms;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public void setName (String name) {
        this.setName = name;
    }

    public void setCategory (String category) {
        this.setCategory = category;
    }

    public String getUserId () {
        return this.userId;
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
