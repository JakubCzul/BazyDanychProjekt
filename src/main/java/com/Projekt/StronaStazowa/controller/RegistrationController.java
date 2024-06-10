package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.Intern;
import com.Projekt.StronaStazowa.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private InternRepository internRepository;

    @GetMapping
    public String registrationPage() {
        return "registrationPage";
    }

    @PostMapping
    public String registerUser(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("age") int age,
                               @RequestParam("mobile") String mobile,
                               @RequestParam("email") String email,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password) {

        Intern intern = new Intern();
        intern.setName(name);
        intern.setSurname(surname);
        intern.setAge(age);
        intern.setMobile(mobile);
        intern.setEmail(email);
        intern.setLogin(login);
        intern.setPassword(password);

        internRepository.save(intern);

        return "redirect:/login";
    }
}
