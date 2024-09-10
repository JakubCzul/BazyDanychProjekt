package com.Projekt.StronaStazowa.repository;

import com.Projekt.StronaStazowa.model.InternshipPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipPostRepository extends JpaRepository<InternshipPost, Long> {
}