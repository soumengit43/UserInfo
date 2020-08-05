package com.UserDetails.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserDetails.demo.dao.AddressRepo;
import com.UserDetails.demo.dao.UserRepo;
import com.UserDetails.demo.model.Address;
import com.UserDetails.demo.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserRepo repo;
	@Autowired
	AddressRepo aRepo;
	
@PostMapping("/addUser")
public String addUser(@RequestBody User userData) {
	
	
	repo.save(userData);
	return "Successfully added";
}

@PutMapping("/editUser/{id}")
public ResponseEntity<User> editUser(@PathVariable(value = "id") int uid,
    @Validated @RequestBody User userData) throws ResourceNotFoundException {
    User objUser = repo.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + uid));

    objUser.setFristName(userData.getFristName());
    objUser.setLastName(userData.getLastName());
    
    final User updatedUser = repo.save(objUser);
    return ResponseEntity.ok(updatedUser);	 
	
}

@GetMapping("/getAllUser")
public List<User> getAllUser() {
	
	return (List<User>) repo.findAll();
}

@GetMapping("/countUser")
public String countUser() {
	List <User> userList=(List<User>) repo.findAll();
	return "No of User="+userList.size();
}

@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int uid) throws ResourceNotFoundException {
    User objUser = repo.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + uid));

    
     repo.delete(objUser);
    return ResponseEntity.ok("User deleted successfully");
	
}

@PostMapping("/addAddress")
public String addAddress(@RequestBody Address addrData) {
	
	
	aRepo.save(addrData);
	return "Address successfully added";
}


@PutMapping("/editAddress/{id}")
public ResponseEntity<Address> editAddress(@PathVariable(value = "id") int aid,
    @Validated @RequestBody Address addrData) throws ResourceNotFoundException {
	Address objAddr = aRepo.findById(aid).orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + aid));

	objAddr.setStreet(addrData.getStreet());
	objAddr.setCity(addrData.getCity());
	objAddr.setState(addrData.getState());
	objAddr.setPostalCode(addrData.getPostalCode());
	
    final Address updatedAddr = aRepo.save(objAddr);
    return ResponseEntity.ok(updatedAddr);	 
	
}

@DeleteMapping("/deleteAddress/{id}")
public ResponseEntity<String> deleteAddress(
		@PathVariable(value = "id") int aid) /* throws ResourceNotFoundException */ {
	Address objAddr=null;
	try {
     objAddr = aRepo.findById(aid).orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + aid));
     aRepo.delete(objAddr);
     return ResponseEntity.ok("Address deleted successfully");

	}
	catch(Exception ex) {
		
		 
		 return ResponseEntity.ok(ex.getMessage());
	}
   
	
}

	
}
