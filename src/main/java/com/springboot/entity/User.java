package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_tb",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String userName;
private String email;
private String accountNumber;
private String status;
public User(String userName, String email, String accountNumber,String status) {
	super();
	this.userName = userName;
	this.email = email;
	this.accountNumber = accountNumber;
	this.status = status;
}
public User()
{
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
