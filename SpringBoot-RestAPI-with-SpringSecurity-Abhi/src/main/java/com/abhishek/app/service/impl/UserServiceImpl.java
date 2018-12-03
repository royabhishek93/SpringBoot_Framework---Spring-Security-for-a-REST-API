package com.abhishek.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.app.model.User;
import com.abhishek.app.repository.UserRepository;
import com.abhishek.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
		
	}
	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		 userRepository.deleteById(id);
		return "{message:User deleted successfully}";
		
	}

}
