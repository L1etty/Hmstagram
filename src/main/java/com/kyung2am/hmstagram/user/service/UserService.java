package com.kyung2am.hmstagram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung2am.hmstagram.common.EncryptUtils;
import com.kyung2am.hmstagram.user.domain.User;
import com.kyung2am.hmstagram.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// LoginId 중복 확인
	public int confirmLoginId(String LoginId) {
		return userRepository.countByLoginId(LoginId);
	}
	
	// 회원가입
	public User addUser(String loginId, String password, String userName, String nickName) {
		
		String encryPassword = EncryptUtils.md5(password);
		
		User user = userRepository.save(User.builder()
				.loginId(loginId)
				.password(encryPassword)
				.userName(userName)
				.nickName(nickName)
				.build());
		
		return user;
		
	}
	
	public User login(String loginId, String password) {
		
		String encryPassword = EncryptUtils.md5(password);
		
		User user = userRepository.findByLoginIdAndPassword(loginId, encryPassword);
		
		return user;
		
	}
	
	public User getUser(int id) {

		return userRepository.findById(id);
	}
	
}
