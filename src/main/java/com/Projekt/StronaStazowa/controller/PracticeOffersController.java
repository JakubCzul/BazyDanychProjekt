package com.Projekt.StronaStazowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practiceOffers")
public class PracticeOffersController {
    @GetMapping
    public String practiceOffersPage() {
        return "practiceOffers";
    }
}
