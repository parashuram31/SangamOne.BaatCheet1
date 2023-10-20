package com.sangamone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangamone.dao.LeavsUsersDao;
import com.sangamone.model.LeavsCompanyUser;
import com.sangamone.model.LeavsUsers;

@RestController
public class LeavsUsersController {
	@Autowired
	LeavsUsersDao leavsUsersDao;
	
	@PostMapping("/addLeavsUser")
	public String addLeavsUser(@RequestBody LeavsCompanyUser leavsCompanyUser) {
		return leavsUsersDao.addLeavsUser(leavsCompanyUser);
	}
	
	@GetMapping("/viewLeavsUsers")
	public List<LeavsUsers> viewLeavsUsers() {
		return leavsUsersDao.viewLeavsUsers();
		
	}
	@GetMapping("viewUsersByCompanyId/{company_id}")
	public List<LeavsUsers>  getUser(@PathVariable ("company_id") int company_id) {
		return leavsUsersDao.findById(company_id);
	}
	@GetMapping("viewUsersByUserId/{user_id}")
	public List<LeavsUsers> getUserByUserId(@PathVariable ("user_id") int user_id){
	return leavsUsersDao.findByUserId(user_id);
	}
	@GetMapping("viewUsersByRole/{user_role}")
	public List<LeavsUsers> viewUsersByRole(@PathVariable ("user_role") String user_role){
		return leavsUsersDao.viewUsersByRole(user_role);
	}
	@GetMapping("viewUsersByCompanyIdRole/{company_id}/{user_role}")
	public List<LeavsUsers> viewUsersByCompanyIdRole(@PathVariable ("company_id") int company_id, 
			@PathVariable ("user_role") String user_role){
		return leavsUsersDao.viewUsersByCompanyIdRole(company_id,user_role);
	}
}
