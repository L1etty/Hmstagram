package com.kyung2am.hmstagram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kyung2am.hmstagram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	public List<Post> findAllByOrderByIdDesc();
	
}
