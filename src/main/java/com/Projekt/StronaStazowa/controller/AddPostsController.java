package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.InternshipPost;
import com.Projekt.StronaStazowa.model.PracticePost;
import com.Projekt.StronaStazowa.repository.InternshipPostRepository;
import com.Projekt.StronaStazowa.repository.PracticePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.sql.Timestamp;

@Controller
@RequestMapping("/addPosts")
public class AddPostsController {

    @Autowired
    private InternshipPostRepository internshipPostRepository;

    @Autowired
    private PracticePostRepository practicePostRepository;

    public AddPostsController(InternshipPostRepository internshipPostRepository, PracticePostRepository practicePostRepository) {
        this.internshipPostRepository = internshipPostRepository;
        this.practicePostRepository = practicePostRepository;
    }

    @GetMapping
    public String showAddPostForm() {
        return "addPosts";
    }

    @PostMapping("/internship")
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
        post.setDuration(Timestamp.valueOf(duration));
        post.setSalary(salary);
        post.setTechnologies(technologies);

        internshipPostRepository.save(post);
        return "redirect:/internshipPosts";
    }

    @PostMapping("/practice")
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
