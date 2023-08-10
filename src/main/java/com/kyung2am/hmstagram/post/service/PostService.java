package com.kyung2am.hmstagram.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.hmstagram.common.FileManger;
import com.kyung2am.hmstagram.post.domain.Post;
import com.kyung2am.hmstagram.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

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
	
	public List<Post> getPostList(){
		return postRepository.findAllUserPost();
	}
	
}
