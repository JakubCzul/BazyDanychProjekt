package com.Projekt.StronaStazowa.repository;

import com.Projekt.StronaStazowa.model.PracticePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticePostRepository extends JpaRepository<PracticePost, Long> {
}