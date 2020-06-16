package com.example.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requests.UserRequest;
import com.example.demo.responses.UserResponse;
import com.example.demo.services.UserService;
import com.example.demo.shared.dto.UserDto;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user was called";
	}
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		//presentation layer
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		//service layer
		UserDto createdUser = userService.createUser(userDto);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(createdUser, userResponse);
		//back to presentation layer
		return userResponse;
		
	}
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
