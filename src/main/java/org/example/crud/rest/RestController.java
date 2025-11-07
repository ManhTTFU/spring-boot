package org.example.crud.rest;

import jakarta.annotation.PostConstruct;
import org.example.crud.entity.Family;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private List<Family> theFamilys;

    @PostConstruct
    public void loadData() {
        theFamilys = new ArrayList<>();
        theFamilys.add(new Family("Manh", "Tran"));
        theFamilys.add(new Family("Manh", "Tran"));
        theFamilys.add(new Family("Manh", "Tran"));
    }

    @GetMapping("/familys")
    public List<Family> getFamilys() {
        return theFamilys;

    }

}
