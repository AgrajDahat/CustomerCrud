package com.agraj.customers.crudoperation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {

	private long id;
	private String firstName;
	private String lastName;
	private Date DOB;
	private String emailId;
	private String password;
	
	public Customer() {
		
	}
	public Customer(long id,String firstName,String lastName,Date DOB,String emailId,String password) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.DOB = DOB;
	this.emailId = emailId;
	this.password = password;
}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "DOB", nullable = false)
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Customer [id="+ id +",firstName="+ firstName + ", lastName=" + lastName +", DOB=" + DOB + ", emailId="+ emailId + "]";
	}
}
