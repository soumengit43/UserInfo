package com.UserDetails.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id	
	private int uid;
	private String fristName;
	private String lastName;
//targetEntity = Address.class,   referencedColumnName = "id"
	
	 // @OneToMany(cascade = CascadeType.ALL)
	 // @JoinColumn(name = "aid")
	@OneToMany(targetEntity = Address.class, mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	  private List<Address> addresses;
	 
	public User() {}
	  	 
	public User(int uid, String fristName, String lastName, List<Address> addresses) {
		super();
		this.uid = uid;
		this.fristName = fristName;
		this.lastName = lastName;
		this.addresses = addresses;
	}
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fristName=" + fristName + ", lastName=" + lastName + "]";
	}
	

}
