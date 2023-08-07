package com.kyung2am.hmstagram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyung2am.hmstagram.user.domain.User;
import com.kyung2am.hmstagram.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	// 아이디 중복 확인
	@GetMapping("/duplicate-id")
	public Map<String, String> confirmLoginId(
				@RequestParam("loginId") String loginId
			){
		
			Map<String, String> duplicateMap = new HashMap<>();
		
			if(userService.confirmLoginId(loginId) == 0) {
				duplicateMap.put("isDuplicate", "false");
			}else {
				duplicateMap.put("isDuplicate", "true");
			}
		
		return duplicateMap;
	}
	
	// 회원가입
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("userName") String userName
			,@RequestParam("nickName") String nickName 
			) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, userName, nickName) != null) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 로그인
	@PostMapping("/login")
	public Map<String, String> login(
				@RequestParam("loginId") String loginId
				,@RequestParam("password") String password
				,HttpSession session
			) {

		User user = userService.login(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getUserName());
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
}
