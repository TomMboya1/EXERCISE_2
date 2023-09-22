package com.example.springboot.exercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public ResponseEntity<String>greeting(){
        String massage ="good afternoon!";
        return new ResponseEntity<>(massage,HttpStatus.OK);
    }
}
