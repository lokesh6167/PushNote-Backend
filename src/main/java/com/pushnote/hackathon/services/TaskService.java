package com.pushnote.hackathon.services;

import java.util.List;

import com.pushnote.hackathon.model.Task;
import com.pushnote.hackathon.model.User;

public interface TaskService {

	Task addNewTask(Task task);

	List<Task> fetchTasks();

}
