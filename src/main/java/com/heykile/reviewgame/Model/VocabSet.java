package com.heykile.reviewgame.Model;

import java.util.List;

import javax.persistence.*;

@Entity
public class VocabSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String setName;
    private String categoryName;
    private int numTermsStudied;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "vocabSet", cascade = CascadeType.ALL)
    private List<Term> vocabTerms;

    public VocabSet() {
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getSetName() {
        return setName;
    }
    
    public void setSetName(String setName) {
        this.setName = setName;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public int getNumTermsStudied() {
        return numTermsStudied;
    }
    
    public void setNumTermsStudied(int numTermsStudied) {
        this.numTermsStudied = numTermsStudied;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Term> getVocabTerms() {
        return vocabTerms;
    }
    
    public void setVocabTerms(List<Term> vocabTerms) {
        this.vocabTerms = vocabTerms;
    }

}
