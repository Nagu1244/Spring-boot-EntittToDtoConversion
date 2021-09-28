package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.UserDto;
import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
@RequestMapping(value = "/api",produces ="application/json",consumes="application/json")
public class UserController {
    @Autowired
	private UserService service;
	@RequestMapping(value="/users",method=RequestMethod.GET)
    public List<UserDto> getAllUserInfo()
    {
    	return service.getAllUserInfo();
    }
	@PostMapping(value="/save")
	public String createUsers(@RequestBody List<User> user)
	{
		service.saveUsers(user);
		return "Users Saved Sucessfully";
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET )
	public UserDto getUserById(@PathVariable(value="id") Long id)
	{
		return service.getUserById(id);
	}
	@GetMapping("/status/query")
	public ResponseEntity<List<UserDto>> getUserByStatus(@RequestParam(name="status") String status)
	{
		return new ResponseEntity<List<UserDto>>(service.getUserByStatus(status),HttpStatus.OK);
    }
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return new ResponseEntity<List<UserDto>>(service.getAllUsers(),HttpStatus.OK);
	}
}
