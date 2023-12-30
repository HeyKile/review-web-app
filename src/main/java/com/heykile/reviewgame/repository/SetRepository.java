package com.heykile.reviewgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heykile.reviewgame.util.VocabSet;

@Repository
public interface SetRepository extends JpaRepository<VocabSet, Long> {
}
