package com.kiri.chop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
