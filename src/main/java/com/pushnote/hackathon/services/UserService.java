package com.pushnote.hackathon.services;

import java.util.List;

import com.pushnote.hackathon.model.User;

public interface UserService {

	User addNewUser(User user);

	List<User> fetchUsers();

}
