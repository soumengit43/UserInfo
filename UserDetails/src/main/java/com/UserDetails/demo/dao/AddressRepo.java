package com.UserDetails.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.UserDetails.demo.model.Address;

public interface AddressRepo extends CrudRepository<Address, Integer> {

}
