package com.kyung2am.hmstagram.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.hmstagram.common.FileManger;
import com.kyung2am.hmstagram.post.domain.Comment;
import com.kyung2am.hmstagram.post.domain.Like;
import com.kyung2am.hmstagram.post.domain.Post;
import com.kyung2am.hmstagram.post.dto.CommentDetail;
import com.kyung2am.hmstagram.post.dto.LikeDetail;
import com.kyung2am.hmstagram.post.dto.PostDetail;
import com.kyung2am.hmstagram.post.repository.CommentRepository;
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
	private CommentRepository commentRepository;
	
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
	
	public List<PostDetail> getPostList(int userId){
		
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
									.likeCount(getLikeCount(post.getId()))
									.likecheck(checkLike(post.getId(), userId))
									.commentCount(getCommentCount(post.getId()))
									.build();
			
			postDetails.add(postDetail);
		}
		
		return postDetails;
		
	}
	
	public String likeManger(int postId, int userId) {
		
		int like = likeRepository.countByPostIdAndUserId(postId, userId);
		
		if(like == 0) {
			// 좋아요 안된 상태
			
			likeRepository.save(Like.builder()
			.postId(postId)
			.userId(userId)
			.build());
			
			return "add";
		}else {
			// 좋아요 된 상태
			
			Like deleteLike = likeRepository.findByPostIdAndUserId(postId, userId);
			
			likeRepository.delete(deleteLike);
			
			return "remove";
		}
	}
	
	public List<LikeDetail> getLikeList(int userId){
//		return likeRepository.findAll();
		
		List<Like> likeList = likeRepository.findAll();
		List<LikeDetail> likeDetailList = new ArrayList<>();
		
		for (Like like : likeList) {
			LikeDetail likeDetail = LikeDetail.builder()
					.id(like.getId())
					.postId(like.getPostId())
					.userId(like.getUserId())
					.checkLike(checkLike(like.getPostId(), userId))
					.build();
			likeDetailList.add(likeDetail);
		}
		return likeDetailList;
	}
	
	public boolean checkLike(int postId, int userId) {
		
		Like like = likeRepository.findByPostIdAndUserId(postId, userId);
		
		if(like != null) {
			return true;
		}
		return false;
	}
	
	public int getLikeCount(int postId) {
		return likeRepository.countByPostId(postId);
	}
	
	public boolean createComment(int postId, String commentContent, int userId) {
		
		Comment comment = commentRepository.save(Comment.builder()
				.postId(postId)
				.commentContent(commentContent)
				.userId(userId)
				.build()
				);
		
		return comment == null;
		
	}
	
	public int getCommentCount(int postId) {
		return commentRepository.countByPostId(postId);
	}
	
	public List<CommentDetail> getCommentList(){
//		return commentRepository.findAll();
		
		List<Comment> commentList = commentRepository.findAll();
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		
		for (Comment comment : commentList) {
			User user = userService.getUser(comment.getUserId());
			
			CommentDetail commentDetail = CommentDetail.builder()
					.id(comment.getId())
					.postId(comment.getPostId())
					.commentContent(comment.getCommentContent())
					.userId(user.getId())
					.userName(user.getUserName())
					.build();
			
			commentDetailList.add(commentDetail);
	
		}
		return commentDetailList;
		
	}
	
	public boolean removePost(int postId, int userId) {
		
		Post post = postRepository.findById(postId).get();
		
		
		if(post.getUserId() == userId) {
			postRepository.delete(post);
			likeRepository.delete(likeRepository.findByPostId(postId));
			commentRepository.delete(commentRepository.findByPostId(postId));
			FileManger.removeFile(post.getContentImagePath());
			
			return true;
		}else {
			return false;
		}
		
	}
}
