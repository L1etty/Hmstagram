package com.kyung2am.hmstagram.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyung2am.hmstagram.post.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	public int countByPostId(int postId);


}
