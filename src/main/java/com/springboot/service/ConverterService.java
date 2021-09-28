package com.springboot.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.dto.UserDto;
import com.springboot.entity.User;

@Component
public class ConverterService {
    @Autowired 
	private  ModelMapper modelMapper;
	public   UserDto convertToDto(User userObject)
	{
		return modelMapper.map(userObject, UserDto.class);
	}
}
