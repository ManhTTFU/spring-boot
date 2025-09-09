package org.example.crud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/team")
    public String getCoachName() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World 3";
    }

    @GetMapping("/milk")
    public String milk() {
        return "milk";
    }
    @GetMapping("/chicken")
    public String chicken() {
        return "chicken";
    }
}