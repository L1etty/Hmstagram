package com.kyung2am.hmstagram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyung2am.hmstagram.post.domain.Comment;
import com.kyung2am.hmstagram.post.domain.Like;
import com.kyung2am.hmstagram.post.dto.CommentDetail;
import com.kyung2am.hmstagram.post.dto.PostDetail;
import com.kyung2am.hmstagram.post.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/timeline")
	public String timeLine(Model model) {
		
		List<PostDetail> postList = postService.getPostList();
		
		List<Like> likeList = postService.getLikeList();
		
		List<CommentDetail> commentList = postService.getCommentList();
		
		model.addAttribute("postList", postList);
		model.addAttribute("likeList", likeList);
		model.addAttribute("commentList", commentList);
		
		return "/post/timeline";
	}
	
}
