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

}
