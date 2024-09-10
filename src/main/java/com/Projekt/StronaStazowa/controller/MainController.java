package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.InternshipPost;
import com.Projekt.StronaStazowa.model.PracticePost;
import com.Projekt.StronaStazowa.repository.InternshipPostRepository;
import com.Projekt.StronaStazowa.repository.PracticePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private InternshipPostRepository internshipPostRepository;

    @Autowired
    private PracticePostRepository practicePostRepository;

    public MainController(InternshipPostRepository internshipPostRepository, PracticePostRepository practicePostRepository) {
        this.internshipPostRepository = internshipPostRepository;
        this.practicePostRepository = practicePostRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<InternshipPost> internshipPosts = internshipPostRepository.findAll();
        List<PracticePost> practicePosts = practicePostRepository.findAll();

        model.addAttribute("internshipPosts", internshipPosts);
        model.addAttribute("practicePosts", practicePosts);

        return "mainPage";
    }
}
