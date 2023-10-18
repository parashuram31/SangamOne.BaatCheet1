package com.sangamone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangamone.dao.LeavsUsersDao;
import com.sangamone.model.Families;
import com.sangamone.model.LeavsCompanies;
import com.sangamone.model.LeavsCompanyUser;
import com.sangamone.model.LeavsUsers;
import com.sangamone.model.Users;
import com.sangamone.repository.LeavsCompaniesRepo;
import com.sangamone.repository.LeavsUsersRepo;

@Service
public class LeavsUsersService implements LeavsUsersDao{
	@Autowired
	LeavsUsersRepo leavsUsersRepo;
	
	@Autowired
	LeavsCompaniesRepo leavsCompaniesRepo;

	@Override
	public String addLeavsUser(LeavsCompanyUser leavsCompanyUser) {
		String result="Family not found";
		LeavsCompanies comp= leavsCompaniesRepo.addLeavsUser(leavsCompanyUser.getCompany());
		if(comp!=null) {
			LeavsUsers leavsUsers =new LeavsUsers();
			leavsUsers.setUser_name(leavsCompanyUser.getUser_name());
			leavsUsers.setUser_pwd(leavsCompanyUser.getUser_pwd());
			leavsUsers.setUser_role(leavsCompanyUser.getUser_role());
			leavsUsers.setCompany_id(comp.getCompany_id());
			leavsUsersRepo.save(leavsUsers);
			result = "added User Successfully";
		}
		return result;
	}

	@Override
	public List<LeavsUsers> viewLeavsUsers() {
		
		return leavsUsersRepo.findAll();
	}

	@Override
	public List<LeavsUsers> findById(int company_id) {
	
		return leavsUsersRepo.findById(company_id);
	}

	

}
