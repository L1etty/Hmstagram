package com.kyung2am.hmstagram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.hmstagram.common.FileManger;
import com.kyung2am.hmstagram.post.domain.Like;
import com.kyung2am.hmstagram.post.domain.Post;
import com.kyung2am.hmstagram.post.dto.PostDetail;
import com.kyung2am.hmstagram.post.repository.LikeRepository;
import com.kyung2am.hmstagram.post.repository.PostRepository;
import com.kyung2am.hmstagram.user.domain.User;
import com.kyung2am.hmstagram.user.service.UserService;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private UserService userService;

	public boolean createPost(MultipartFile contentImagePath, String content, int userId) {
		
		String filePath = FileManger.saveFile(userId, contentImagePath);
		
		Post post = postRepository.save(Post.builder()
				.contentImagePath(filePath)
				.content(content)
				.userId(userId)
				.build()
				);
				

		return post == null;
	}
	
	public List<PostDetail> getPostList(){
//		List<Post> postList = postRepository.findAll();
//		
//		Map<Post, User> puList = new HashMap<>();
//		
//		for (Post post : postList) {
//		
//			puList.put(post, userRepository.findById(post.getUserId()));
//			
//		}
//		
//		return puList;
		
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		List<PostDetail> postDetails = new ArrayList<>();
		
		for (Post post : postList) {
			
			User user = userService.getUser(post.getUserId());
			
			PostDetail postDetail = PostDetail.builder()
									.id(post.getId())
									.content(post.getContent())
									.contentImagePath(post.getContentImagePath())
									.userId(post.getUserId())
									.userName(user.getUserName())
									.build();
			
			postDetails.add(postDetail);
		}
		
		return postDetails;
		
	}
	
	public String likeManger(int postId, int userId) {
		
		int like = likeRepository.countByPostIdAndUserId(postId, userId);
		
		if(like == 0) {
			// 좋아요 안된 상태
			
			Like.builder()
			.postId(postId)
			.userId(userId)
			.build();
			
			return "add";
		}else {
			// 좋아요 된 상태
			
			likeRepository.deleteByPostId(postId);
			
			return "remove";
		}
		
		
	}
	
}
