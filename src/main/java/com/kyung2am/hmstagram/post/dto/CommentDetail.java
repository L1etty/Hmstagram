package com.kyung2am.hmstagram.post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentDetail {

	private int id;
	private int postId;
	private String commentContent;
	private int userId;
	private String userName;
	
}
