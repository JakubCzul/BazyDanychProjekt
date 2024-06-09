package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.User;
import com.Projekt.StronaStazowa.repository.UserRepository;
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
    private UserRepository userRepository;


    @GetMapping
    public String registrationPage() {
        return "registrationPage";
    }

    @PostMapping
    public String registerUser(@RequestParam("login") String login,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password) {

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        return "redirect:/login";
    }
}
