package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.PracticePost;
import com.Projekt.StronaStazowa.repository.PracticePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/practicePosts")
public class PracticePostsController {

    @Autowired
    private PracticePostRepository practicePostRepository;

    public PracticePostsController(PracticePostRepository practicePostRepository) {
        this.practicePostRepository = practicePostRepository;
    }

    @GetMapping
    public String getPracticePosts(Model model) {
        List<PracticePost> posts = practicePostRepository.findAll();
        model.addAttribute("posts", posts);
        return "practicePosts";
    }

    @PostMapping("/add")
    public String addPracticePost(@RequestParam String title,
                                  @RequestParam String adress,
                                  @RequestParam String description,
                                  @RequestParam String duration,
                                  @RequestParam Integer salary,
                                  @RequestParam String technologies,
                                  Principal principal) {
        PracticePost post = new PracticePost();
        post.setTitle(title);
        post.setAdress(adress);
        post.setDescription(description);
        post.setDuration(Timestamp.valueOf(duration));
        post.setSalary(salary);
        post.setTechnologies(technologies);

        practicePostRepository.save(post);
        return "redirect:/practicePosts";
    }
}
