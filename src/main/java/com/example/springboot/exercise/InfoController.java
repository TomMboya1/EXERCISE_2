package com.example.springboot.exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>("This is the information endpoint", HttpStatus.OK);
    }
}