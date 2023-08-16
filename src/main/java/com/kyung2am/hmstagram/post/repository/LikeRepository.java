package com.kyung2am.hmstagram.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyung2am.hmstagram.post.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

	public int countByPostIdAndUserId(int postId, int userId);

	public Like findByPostId(int postId);

	public int countByPostId(int postId);

	public Like findByPostIdAndUserId(int postId, int userId);

}
