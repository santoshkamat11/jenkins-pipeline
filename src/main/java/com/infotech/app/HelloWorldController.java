package com.infotech.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value = "/welcome")
	public String welcome() {
		return "Welcome to spring boot";
		
	}
}
