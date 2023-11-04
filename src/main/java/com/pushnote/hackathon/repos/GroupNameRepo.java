package com.pushnote.hackathon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pushnote.hackathon.model.GroupName;

@Repository
public interface GroupNameRepo extends JpaRepository<GroupName, Integer> {

}
