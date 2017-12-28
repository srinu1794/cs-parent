package com.cg.userprofile.repo;

import org.springframework.data.repository.CrudRepository;

import com.cg.userprofile.User;


public interface UserProfileRepo extends CrudRepository<User, Long> {

}
