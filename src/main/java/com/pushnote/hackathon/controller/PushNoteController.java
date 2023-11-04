package com.pushnote.hackathon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pushnote.hackathon.model.GroupName;
import com.pushnote.hackathon.model.Task;
import com.pushnote.hackathon.model.User;
import com.pushnote.hackathon.repos.GroupNameRepo;
import com.pushnote.hackathon.repos.TaskRepo;
import com.pushnote.hackathon.repos.UserRepo;
import com.pushnote.hackathon.services.GroupNameService;
import com.pushnote.hackathon.services.TaskService;
import com.pushnote.hackathon.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/pushnote")
public class PushNoteController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupNameService groupNameService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private GroupNameRepo groupNameRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	
	@GetMapping("/testServer")
	public String testingServer(){
		return "Hi I am up.. You can use me..";
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
	
	@PostMapping("/addGroupName")
	public GroupName addGroupName(@RequestBody GroupName groupName) {
		return groupNameService.addNewGroupName(groupName);
	}

	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task) {
		return taskService.addNewTask(task);
	}
	
	@GetMapping("/fetchUsers")
	public List<User> fetchUsers(){
	        return userService.fetchUsers();
	}

	@GetMapping("/fetchGroups")
	public List<GroupName> fetchGroupName(){
	        return  groupNameService.fetchGroupName();
	}

	@GetMapping("/fetchTasks")
	public List<Task> fetchTasks(){
	        return  taskService.fetchTasks();
	}
	
	@GetMapping("/fetchUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@GetMapping("/fetchGroup/{id}")
    public ResponseEntity<GroupName> getGroupNameByID(@PathVariable int id) {
        Optional<GroupName> optionalGroup = groupNameRepo.findById(id);

        if (optionalGroup.isPresent()) {
            return ResponseEntity.ok(optionalGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/fetchTask/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable int id) {
	    Optional<Task> optionalTask = taskRepo.findById(id);

	    if (optionalTask.isPresent()) {
	        return ResponseEntity.ok(optionalTask.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/updateGroup/{id}")
	public ResponseEntity<GroupName> updateGroupNameDetails(@PathVariable Integer id, @RequestBody GroupName updatedGroupName) {
	    Optional<GroupName> optionalGroupName = groupNameRepo.findById(id);

	    if (optionalGroupName.isPresent()) {
	        GroupName group = optionalGroupName.get();
	        group.setGroupName(updatedGroupName.getGroupName());
	        group.setManager(updatedGroupName.getManager());
	        group.setDescription(updatedGroupName.getDescription());
	        group.setChatId(updatedGroupName.getChatId());
	        GroupName updatedGroup = groupNameRepo.save(group);
	        return ResponseEntity.ok(updatedGroup);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable Integer id, @RequestBody User updatedUserDetails) {
	    Optional<User> optionalUser = userRepo.findById(id);

	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setName(updatedUserDetails.getName());
	        user.setEmail(updatedUserDetails.getEmail());
	        user.setPhone(updatedUserDetails.getPhone());
	        user.setUsername(updatedUserDetails.getUsername());
	        user.setPassword(updatedUserDetails.getPassword());
	        user.setImage(updatedUserDetails.getImage());
	        user.setRole(updatedUserDetails.getRole());
	        user.setAttendance(updatedUserDetails.getAttendance());
	        User updatedUser = userRepo.save(user);
	        return ResponseEntity.ok(updatedUser);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task updatedTask) {
	    Optional<Task> optionalTask = taskRepo.findById(id);

	    if (optionalTask.isPresent()) {
	        Task task = optionalTask.get();
	        task.setTitle(updatedTask.getTitle());
	        task.setDescription(updatedTask.getDescription());
	        task.setCreatedBy(updatedTask.getCreatedBy());
	        task.setAssignedTo(updatedTask.getAssignedTo());
	        task.setStatus(updatedTask.getStatus());
	        task.setDeadline(updatedTask.getDeadline());
	        task.setTracking(updatedTask.getTracking());
	        task.setChatId(updatedTask.getChatId());
	        Task updatedTask1 = taskRepo.save(task);
	        return ResponseEntity.ok(updatedTask1);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
