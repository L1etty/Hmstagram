package com.kyung2am.hmstagram.post.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "postComment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "postId")
	private int postId;
	

	@Column(name = "userId")
	private int userId;
	

	@Column(name = "commentContent")
	private String commentContent;
	

	@Column(name = "createdAt", updatable = false)
	@UpdateTimestamp
	private ZonedDateTime createdAt;
	

	@Column(name = "updatedAt")
	@UpdateTimestamp
	private ZonedDateTime updatedAt;
	
}
