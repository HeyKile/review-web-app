package com.heykile.reviewgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heykile.reviewgame.Model.VocabSet;

import java.util.List;


@Repository
public interface SetRepository extends JpaRepository<VocabSet, Long> {

    List<VocabSet> findByUserId(String userId);

}
