package com.Projekt.StronaStazowa.repository;

import com.Projekt.StronaStazowa.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {
    Intern findByEmail(String email);
}