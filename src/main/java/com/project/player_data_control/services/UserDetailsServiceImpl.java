package com.project.player_data_control.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.User;
import com.project.player_data_control.repository.UserRepository;
import com.project.player_data_control.security.MyUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		if(user==null) {
			System.out.println("boş kullanıcı");
		}
		
		MyUserDetails myUserDetails=new MyUserDetails(user);
		return myUserDetails;
	}
	

}
