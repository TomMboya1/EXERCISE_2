package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
	@GetMapping(value = "/good-morning")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Good morning!");
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		String message = "Good Afternoon!";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/info")
	public ResponseEntity<String> getInfo() {
		return new ResponseEntity<>("This is the information endpoint", HttpStatus.OK);
	}
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
