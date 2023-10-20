package com.sangamone.dao;

import java.util.List;

import com.sangamone.model.LeavsCompanyUser;
import com.sangamone.model.LeavsUsers;

public interface LeavsUsersDao {

	String addLeavsUser(LeavsCompanyUser leavsCompanyUser);

	List<LeavsUsers> viewLeavsUsers();

	List<LeavsUsers> findById(int company_id);

	List<LeavsUsers> findByUserId(int user_id);

	List<LeavsUsers> viewUsersByRole(String user_role);

	List<LeavsUsers> viewUsersByCompanyIdRole(int company_id, String user_role);

	



}
