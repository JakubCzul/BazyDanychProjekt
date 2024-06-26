package com.Projekt.StronaStazowa.controller;

import com.Projekt.StronaStazowa.model.Company;
import com.Projekt.StronaStazowa.model.Intern;
import com.Projekt.StronaStazowa.repository.CompanyRepository;
import com.Projekt.StronaStazowa.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.Projekt.StronaStazowa.Hashing.Hashing.doHashing;

@Controller
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model) {

        // Sprawdzanie czy użytkownik to intern
        Intern intern = internRepository.findByEmail(email);
        if (intern != null && intern.getPassword().equals(doHashing(password))) {
            model.addAttribute("user", intern);
            return "redirect:/"; // Przekierowanie do strony ofert staży
        }

        // Sprawdzanie czy użytkownik to firma
        Company company = companyRepository.findByEmail(email);
        if (company != null && company.getPassword().equals(doHashing(password))) {
            model.addAttribute("user", company);
            return "redirect:/"; // Przekierowanie do strony ofert firmy
        }

        // Jeśli logowanie nie powiodło się, przekierowanie z powrotem do strony logowania z komunikatem
        model.addAttribute("error", true);
        return "loginPage";
    }
}
