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
import java.util.List;

@Controller
@RequestMapping("/practicePosts")
public class PracticePostsController {

    @Autowired
    private PracticePostRepository practicePostRepository;

    @GetMapping
    public String getPracticePosts(Model model) {
        List<PracticePost> posts = practicePostRepository.findAll();
        model.addAttribute("posts", posts);
        return "practicePosts";
    }

    @PostMapping("/add")
    public String addPracticePost(@RequestParam String title, @RequestParam String content, Principal principal) {
        PracticePost post = new PracticePost();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(principal.getName());

        practicePostRepository.save(post);
        return "redirect:/practicePosts";
    }
}
