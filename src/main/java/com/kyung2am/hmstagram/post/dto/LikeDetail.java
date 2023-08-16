package com.kyung2am.hmstagram.post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LikeDetail {

	private int id;
	private int postId;
	private int userId;
	private boolean checkLike;
	
}
