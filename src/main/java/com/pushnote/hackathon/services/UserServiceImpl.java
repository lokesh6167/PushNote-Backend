package com.pushnote.hackathon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushnote.hackathon.model.User;
import com.pushnote.hackathon.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public List<User> fetchUsers(){
	      return userRepo.findAll();
	}
}
