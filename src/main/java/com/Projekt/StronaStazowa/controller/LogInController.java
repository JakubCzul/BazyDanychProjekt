package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.Company;
import com.Projekt.StronaStazowa.model.Intern;
import com.Projekt.StronaStazowa.repository.CompanyRepository;
import com.Projekt.StronaStazowa.repository.InternRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.*;

import static com.Projekt.StronaStazowa.Hashing.Hashing.doHashing;

@Controller
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public LogInController(InternRepository internRepository, CompanyRepository companyRepository) {
        this.internRepository = internRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession session) {


        Intern intern = internRepository.findByEmail(email);
        if (intern != null && intern.getPassword().equals(doHashing(password))) {
            session.setAttribute("user", intern);
            return "redirect:/";
        }

        Company company = companyRepository.findByEmail(email);
        if (company != null && company.getPassword().equals(doHashing(password))) {
            session.setAttribute("user", company);
            return "redirect:/";
        }

        model.addAttribute("error", true);
        return "loginPage";
    }
}
