package com.cg.userprofile.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.userprofile.User;


public interface UserProfileRepo extends JpaRepository<User, Long> {

}
