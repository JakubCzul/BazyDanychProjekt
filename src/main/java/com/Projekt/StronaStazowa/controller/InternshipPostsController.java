package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.InternshipPost;
import com.Projekt.StronaStazowa.repository.InternshipPostRepository;
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
@RequestMapping("/internshipPosts")
public class InternshipPostsController {

    @Autowired
    private InternshipPostRepository internshipPostRepository;

    public InternshipPostsController(InternshipPostRepository internshipPostRepository) {
        this.internshipPostRepository = internshipPostRepository;
    }

    @GetMapping
    public String getInternshipPosts(Model model) {
        List<InternshipPost> posts = internshipPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "internshipPosts";
    }

    @PostMapping("/add")
    public String addInternshipPost(@RequestParam String title,
                                    @RequestParam String adress,
                                    @RequestParam String description,
                                    @RequestParam String duration,
                                    @RequestParam Integer salary,
                                    @RequestParam String technologies,
                                    Principal principal) {
        InternshipPost post = new InternshipPost();
        post.setTitle(title);
        post.setAdress(adress);
        post.setDescription(description);
        post.setDuration(Timestamp.valueOf(duration)); // Upewnij się, że format pasuje do TIMESTAMP
        post.setSalary(salary);
        post.setTechnologies(technologies);

        internshipPostRepository.save(post);
        return "redirect:/internshipPosts";
    }
}
