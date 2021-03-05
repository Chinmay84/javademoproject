package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String forHomePage() {
		
		return "home";
	}
	
	@RequestMapping("/about")
	public String forAboutPage() {
		return "about";
	}

}
