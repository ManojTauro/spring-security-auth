package com.manoj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class CardsController {

    @GetMapping("cards")
    public String getCardsDetails() {
        return " Cards details";
    }
}
