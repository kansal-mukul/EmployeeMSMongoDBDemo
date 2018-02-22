package com.hcl.microservice.employee;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9100174010021734334L;
	@Id
	private Long id;
	private String firstName;
	private String lastName;



	public Employee() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
