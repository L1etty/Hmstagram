package com.kyung2am.hmstagram.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class PostDetail {

	//id, content, imagePath, userId, userName
	
	private int id;
	private String content;
	private String contentImagePath;
	private int userId;
	private String userName;
	
}
