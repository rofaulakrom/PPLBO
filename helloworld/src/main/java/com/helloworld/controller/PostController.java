package com.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
	@RequestMapping("/welcome")
	@ResponseBody
	public String getWelComePage() {
		return "<h2>Welcome!</h2>";
	}
}
