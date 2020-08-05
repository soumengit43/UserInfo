package com.UserDetails.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Address {
	@Id	 
	private int aid;
	private String street;
	private String city;
	private String state;
	private int postalCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "u_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private User user;
	
	public Address() {}
	
	public Address(int aid, String street, String city, String state, int postalCode) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	
	public int getAid() {
		return aid; 
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
	@Override
	public String toString() {
		return "Adderss [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + "]";
	}
	
	

}
