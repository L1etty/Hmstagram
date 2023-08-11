package com.kyung2am.hmstagram.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyung2am.hmstagram.user.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public int countByLoginId(String loginId);
	
	public User findByLoginIdAndPassword(String loginId, String password);

	public User findById(int userId);

}
