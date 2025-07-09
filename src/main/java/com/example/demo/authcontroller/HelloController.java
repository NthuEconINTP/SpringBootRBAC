package com.example.demo.authcontroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	    @GetMapping("/employee")
	    public String get() {

	        return "hello";

	    }
	 

	
}
