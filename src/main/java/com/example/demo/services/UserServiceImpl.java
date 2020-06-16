package com.example.demo.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserEntity;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setEncryptedPassword("test password");
		userEntity.setUserId("user test id");
		UserEntity newUser = userRepository.save(userEntity);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(newUser, userDto);		
		return userDto;
	}

}
