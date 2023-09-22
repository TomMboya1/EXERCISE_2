package com.example.springboot.exercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping("/random")
    public ResponseEntity<String> getRandomResponse() {
        boolean isOk = new Random().nextBoolean();

        if (isOk) {
            return new ResponseEntity<>("Success! (200 OK)", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad Request! (400 Bad Request)", HttpStatus.BAD_REQUEST);
        }
    }
}
