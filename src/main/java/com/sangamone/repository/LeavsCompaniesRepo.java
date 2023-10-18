package com.sangamone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sangamone.model.Families;
import com.sangamone.model.LeavsCompanies;




public interface LeavsCompaniesRepo extends JpaRepository<LeavsCompanies, Integer>{

	@Query(value="select * from leavs_companies where company =:company", nativeQuery=true)
	public LeavsCompanies addLeavsUser(@Param("company") String company);

}
