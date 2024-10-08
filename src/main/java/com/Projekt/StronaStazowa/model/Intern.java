package com.Projekt.StronaStazowa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = true)
    private String university;

    @Column(nullable = true)
    private String faculty;

    @Column(nullable = true)
    private String cv = "Przykladowe";

}
