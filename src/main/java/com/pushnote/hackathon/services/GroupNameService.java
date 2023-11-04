package com.pushnote.hackathon.services;

import java.util.List;

import com.pushnote.hackathon.model.GroupName;
import com.pushnote.hackathon.model.User;

public interface GroupNameService {

	GroupName addNewGroupName(GroupName groupName);

	List<GroupName> fetchGroupName();

}
