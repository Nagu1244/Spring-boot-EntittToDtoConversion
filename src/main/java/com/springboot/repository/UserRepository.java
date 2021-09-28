package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.dto.UserDto;
import com.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//JPQL Quries(Java Persistence Query Language)--@Query(value="SELECT ud FROM User ud where ud.status=?1")
	//NativeQuery---(value="SELECT * FROM User ud where ud.status=?1",nativeQuery = true)
	//@Query(value="SELECT ud FROM User ud where ud.status=?1")	
@Query(value="SELECT * FROM  user_tb ud where ud.status=?1",nativeQuery = true)
 public List<User> getUserByStatus(String status);
@Query(value="SELECT * FROM user_tb",nativeQuery = true)
public List<User> getAllUsers();


}
	