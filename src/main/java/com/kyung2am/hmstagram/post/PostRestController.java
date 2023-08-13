package com.kyung2am.hmstagram.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.hmstagram.post.service.PostService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public Map<String, String> create(
				@RequestParam("contentImagePath") MultipartFile contentImagePath
				,@RequestParam("content") String content
				,HttpSession session
			){
			int userId = (Integer)session.getAttribute("userId");
			
			Map<String, String> resultMap = new HashMap<>();
			
			
			if(postService.createPost(contentImagePath, content, userId)) {
				resultMap.put("result", "success");
			}else {
				resultMap.put("result", "fail");
			}
		
		return resultMap;
	}
	
	@PostMapping("/like")
	public Map<String, String> like(
			@RequestParam("postId") int postId
			,HttpSession session
			){
		
		Map<String, String> resultMap = new HashMap<>();
		
		int userId = (Integer)session.getAttribute("userId");
		
		String like = postService.likeManger(postId, userId);
		
		if(like.equals("add")) {
			resultMap.put("result", "add");
		}else if(like.equals("remove")) {
			resultMap.put("result", "remove");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
}
