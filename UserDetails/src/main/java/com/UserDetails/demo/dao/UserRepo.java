package com.UserDetails.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.UserDetails.demo.model.User;


public interface UserRepo extends CrudRepository<User, Integer> {
	
	/*
	 * @Query("select new com.UserDetails.demo.model.UserResponse(u.fristName, a.aid) from User u LEFT JOIN u.addresses a"
	 * ) public List <UserResponse> getJoinInfo();
	 */
}
