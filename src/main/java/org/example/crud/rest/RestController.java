package org.example.crud.rest;

import jakarta.annotation.PostConstruct;
import org.example.crud.entity.Family;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/familys/{familyId}")
    public Family getFamily(@PathVariable int familyId) {
        if((familyId >= theFamilys.size()) || (familyId < 0)) {
            throw new FamilyNotFoundException("Family id not found" + '-' + familyId);
        }
        return  theFamilys.get(familyId);
    }

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<FamilyErrorResponse> handleException(FamilyNotFoundException exc) {
        //create a StudentErrorResponse
        FamilyErrorResponse error = new FamilyErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to c atch any exception ( catch all )
    @ExceptionHandler
    public ResponseEntity<FamilyErrorResponse> handleException(RuntimeException exc) {
        //create a StudentErrorResponse
        FamilyErrorResponse error = new FamilyErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
