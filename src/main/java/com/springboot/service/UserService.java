package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.UserDto;
import com.springboot.entity.User;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class UserService {
    @Autowired
	private UserRepository repository;
    @Autowired
    private ConverterService converterService;
	public List<UserDto> getAllUserInfo()
	{
		List<User> listUsers=repository.findAll();
		//map method converts Entity to DTO based fields defined in the DTO class
		return listUsers.stream().map(converterService::convertToDto).collect(Collectors.toList()); 
		
		
	}
	public void saveUsers(List<User> user) {
		repository.saveAll(user);
		
	}
	public UserDto getUserById(Long id)
	{
		Optional<User> user=repository.findById(id);
		if(user.isPresent())
		{
			User exisUser=user.get();
			return converterService.convertToDto(exisUser);
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}
	public List<UserDto> getUserByStatus(String status)
	{
		List<User> usersList=repository.getUserByStatus(status);
		return usersList.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}
	public List<UserDto> getAllUsers()
	{
		List<User> user=repository.findAll();
		return user.stream().map(converterService::convertToDto).collect(Collectors.toList());
	}
}
