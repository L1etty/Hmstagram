package com.kyung2am.hmstagram.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/join-view")
	public String join() {
		return "/user/join";
	}
	
	@GetMapping("/login-view")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
	}
	
}
