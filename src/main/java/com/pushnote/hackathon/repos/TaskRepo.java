package com.pushnote.hackathon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pushnote.hackathon.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
