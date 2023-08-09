package com.kyung2am.hmstagram.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyung2am.hmstagram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
