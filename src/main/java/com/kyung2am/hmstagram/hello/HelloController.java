package com.kyung2am.hmstagram.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String Hello() {
		return "hello world";
	}
	
	@GetMapping("/hello/jsp")
	public String Hellojsp() {
		return "/hello/hello";
	}
	
}
