package com.kiri.chop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/gift/list")
	public String giftList() {
		return "listing";
	}
	
	@GetMapping("/gift/detail")
	public String giftDetail() {
		return "listDetail";
	}
	
	@GetMapping("/gift/write")
	public String giftWrite() {
		return "listWrite";
	}
}
