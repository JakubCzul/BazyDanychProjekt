package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.InternshipPost;
import com.Projekt.StronaStazowa.model.PracticePost;
import com.Projekt.StronaStazowa.repository.InternshipPostRepository;
import com.Projekt.StronaStazowa.repository.PracticePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

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
    public String mainPage(
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "language", required = false) String language,
            Model model) {

        List<InternshipPost> internshipPosts = internshipPostRepository.findAll();
        List<PracticePost> practicePosts = practicePostRepository.findAll();

        if (city != null && !city.isEmpty()) {
            internshipPosts = internshipPosts.stream()
                    .filter(post -> city.equals(post.getAdress()))
                    .collect(Collectors.toList());

            practicePosts = practicePosts.stream()
                    .filter(post -> city.equals(post.getAdress()))
                    .collect(Collectors.toList());
        }

        if (language != null && !language.isEmpty()) {
            internshipPosts = internshipPosts.stream()
                    .filter(post -> post.getTechnologies().contains(language))
                    .collect(Collectors.toList());

            practicePosts = practicePosts.stream()
                    .filter(post -> post.getTechnologies().contains(language))
                    .collect(Collectors.toList());
        }

        model.addAttribute("internshipPosts", internshipPosts);
        model.addAttribute("practicePosts", practicePosts);

        model.addAttribute("cities", List.of("Gliwice", "Kraków", "Katowice", "Wrocław", "Warszawa"));
        model.addAttribute("languages", List.of("Java", "Python", "JavaScript", "C#", "C++"));

        return "mainPage";
    }
}
