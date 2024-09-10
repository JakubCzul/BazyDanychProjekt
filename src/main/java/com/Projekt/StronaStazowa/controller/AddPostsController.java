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
        InternshipPost internshipPost = new InternshipPost();
        internshipPost.setTitle(title);
        internshipPost.setAdress(adress);
        internshipPost.setDescription(description);
        internshipPost.setDuration(Timestamp.valueOf(duration));
        internshipPost.setSalary(salary);
        internshipPost.setTechnologies(technologies);

        internshipPostRepository.save(internshipPost);

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
        PracticePost practicePost = new PracticePost();
        practicePost.setTitle(title);
        practicePost.setAdress(adress);
        practicePost.setDescription(description);
        practicePost.setDuration(Timestamp.valueOf(duration));
        practicePost.setSalary(salary);
        practicePost.setTechnologies(technologies);

        practicePostRepository.save(practicePost);

        return "redirect:/practicePosts";
    }
}
