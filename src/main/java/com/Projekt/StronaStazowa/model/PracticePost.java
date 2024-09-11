package com.Projekt.StronaStazowa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "practice_posts")
public class PracticePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 100)
    private String adress;

    @Column(columnDefinition = "TEXT")
    private String description;

    private java.sql.Timestamp duration;

    @Column(columnDefinition = "SMALLINT UNSIGNED")
    private Integer salary;

    @Column(length = 255)
    private String technologies;

    @Column(length = 100)
    private String city;
}
