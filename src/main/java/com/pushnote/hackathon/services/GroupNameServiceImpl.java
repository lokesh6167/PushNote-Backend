package com.pushnote.hackathon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushnote.hackathon.model.GroupName;
import com.pushnote.hackathon.model.User;
import com.pushnote.hackathon.repos.GroupNameRepo;

@Service
public class GroupNameServiceImpl implements GroupNameService {

	@Autowired
	GroupNameRepo groupNameRepo;

	@Override
	public GroupName addNewGroupName(GroupName groupName) {
		return groupNameRepo.save(groupName);
	}
	
	@Override
	public List<GroupName> fetchGroupName(){
		return groupNameRepo.findAll();
	}
}
