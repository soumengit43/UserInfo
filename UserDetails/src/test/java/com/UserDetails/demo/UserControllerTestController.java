package com.UserDetails.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.UserDetails.demo.controller.UserController;
import com.UserDetails.demo.dao.AddressRepo;
import com.UserDetails.demo.dao.UserRepo;
import com.UserDetails.demo.model.Address;
import com.UserDetails.demo.model.User;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTestController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserRepo repo;
	@MockBean
	AddressRepo aRepo;
	
	Address addUserAddr=new Address(3, "Lincon", "Hyd","Tolli",6);
	User mockAddUser=new User(3, "soumen2", "das2",Arrays.asList(addUserAddr));
	User mockEditUser=new User(3,"soumen3","das3",Arrays.asList());
	Address editUserAddr=new Address(3, "Lincon2", "Hyd2","Tolli2",7);
	
	
	String addUserJson= "{\"uid\": 3,\"fristName\": \"soumen2\",\"lastName\": \"das2\",\"addresses\": [{\"aid\": 1,\"street\": \"Manikonda\",\"city\": \"Road\",\"state\": \"Hyd\",\"postalCode\": 5}]}";
	String editUserJson= "{\"fristName\": \"soumen2\",\"lastName\": \"das\"}";
	String editAddressJson= "{\"street\": \"Manikonda1\",\"city\": \"Road2\",\"state\": \"Hyd2\",\"postalCode\": 55 }";
	
	@Test
	public void addUserTest() throws Exception {
		Mockito.when(repo.save(Mockito.any(User.class))).thenReturn(mockAddUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addUser")
				.accept(MediaType.APPLICATION_JSON).content(addUserJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		assertEquals(response.getContentAsString(),"User is added successfully");
			
	}
	
	@Test
	public void editUserTest() throws Exception {
		Mockito.when(repo.save(Mockito.any(User.class))).thenReturn(mockEditUser);
		
	
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editUser/1").accept(MediaType.APPLICATION_JSON).contentType(editUserJson);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		
		assertEquals(response.getContentAsString(),"User is updated successfully");
			
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void allUserTest() throws Exception {
		
		List<User> mockAllUser=new ArrayList<>();		
		mockAllUser.add(mockAddUser);
		
		Mockito.when((List<User>)repo.findAll()).thenReturn(mockAllUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllUser").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		
		assertEquals(response.getContentAsString(),"Retrive successfully");
			
	}
	
	@Test
	public void countUserTest() throws Exception {
		List<User> mockAllUser=new ArrayList<>();		
		mockAllUser.add(mockAddUser);
		
		Mockito.when((List<User>)repo.findAll()).thenReturn(mockAllUser);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/countUser").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(mockAllUser.size(), 1);
		
		assertEquals(response.getContentAsString(),"Count matched");
			
	}
	
	@Test
	public void editAddressTest() throws Exception {
		Mockito.when(aRepo.save(Mockito.any(Address.class))).thenReturn(editUserAddr);
		
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/editAddress/2").accept(MediaType.APPLICATION_JSON).contentType(editAddressJson);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		
		assertEquals(response.getContentAsString(),"Address is updated successfully");
			
	}
	
	@Test
	public void addAddressTest() throws Exception {
		Mockito.when(aRepo.save(Mockito.any(Address.class))).thenReturn(addUserAddr);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addAddress")
				.accept(MediaType.APPLICATION_JSON).content(editAddressJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		assertEquals(response.getContentAsString(),"Address is added successfully");
			
	}
	
	
	@Test
	public void deleteAddressTest() throws Exception {
		 
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteAddress/2").accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		
		assertEquals(response.getContentAsString(),"Address is deleted successfully");
			
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		 
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteUser/2").accept(MediaType.APPLICATION_JSON);
		 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		
		assertEquals(response.getContentAsString(),"User is deleted successfully");
			
	}
	
	
}
