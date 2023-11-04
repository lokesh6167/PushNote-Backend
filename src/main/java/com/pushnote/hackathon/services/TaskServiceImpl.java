package com.pushnote.hackathon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushnote.hackathon.model.Task;
import com.pushnote.hackathon.repos.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepo taskRepo;

	@Override
	public Task addNewTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public List<Task> fetchTasks() {
		return taskRepo.findAll();
	}

}
