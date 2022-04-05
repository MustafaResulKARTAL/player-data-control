package com.project.player_data_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.player_data_control.entityes.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	User findByUserEmail(String userEmail);


}
