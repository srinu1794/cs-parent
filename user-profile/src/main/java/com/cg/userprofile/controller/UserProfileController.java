package com.cg.userprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.userprofile.User;
import com.cg.userprofile.repo.UserProfileRepo;

@RestController
@RequestMapping("users")
public class UserProfileController {

	@Autowired
	private UserProfileRepo profileRepo;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return profileRepo.save(user);
	}

	@RequestMapping(value = "findbyid", method = RequestMethod.GET, params = { "userId" })
	public User getUserById(@RequestParam(value = "userId", required = true) String userId) {
		return profileRepo.findOne(Long.parseLong(userId));
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return profileRepo.findAll();
	}

	@RequestMapping(value = "credit", method = RequestMethod.POST, params = { "userId", "amount" })
	public User credit(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "amount", required = true) String amount) {
		User user = profileRepo.findOne(Long.parseLong(userId));
		user.setBalance(user.getBalance() + Long.parseLong(amount));
		return profileRepo.save(user);
	}

	@RequestMapping(value = "debit", method = RequestMethod.POST, params = { "userId", "amount" })
	public User debit(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "amount", required = true) String amount) {
		User user = profileRepo.findOne(Long.parseLong(userId));
		user.setBalance(user.getBalance() - Long.parseLong(amount));
		return profileRepo.save(user);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public User update(@RequestBody User user) {
		return profileRepo.save(user);
	}
}
