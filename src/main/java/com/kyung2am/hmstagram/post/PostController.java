package com.kyung2am.hmstagram.post;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyung2am.hmstagram.post.domain.Post;
import com.kyung2am.hmstagram.post.dto.PostDetail;
import com.kyung2am.hmstagram.post.service.PostService;
import com.kyung2am.hmstagram.user.domain.User;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/timeline")
	public String timeLine(Model model) {
		
		List<PostDetail> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "/post/timeline";
	}
	
}
