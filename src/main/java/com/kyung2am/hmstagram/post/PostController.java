package com.kyung2am.hmstagram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyung2am.hmstagram.post.domain.Post;
import com.kyung2am.hmstagram.post.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/timeline")
	public String timeLine(Model model) {
		
		List<Post> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "/post/timeline";
	}
	
}
