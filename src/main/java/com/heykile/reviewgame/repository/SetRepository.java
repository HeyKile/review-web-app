package com.heykile.reviewgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heykile.reviewgame.Model.VocabSet;

import java.util.List;


@Repository
public interface SetRepository extends JpaRepository<VocabSet, Long> {

    // returns list of all vocab sets for a user
    List<VocabSet> findByUserId(long id);

    // returns a given user's VocabSet of the given set name
    VocabSet findByUserAndSetName(long id, String setName);

    // returns a list of a user's vocab sets for a given category
    List<VocabSet> findByUserAndCategoryName(long id, String categoryName);
}
