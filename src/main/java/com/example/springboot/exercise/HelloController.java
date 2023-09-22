package com.example.springboot.exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HelloController {
    @Autowired
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
