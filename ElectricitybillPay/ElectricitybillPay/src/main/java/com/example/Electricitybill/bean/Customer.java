package com.example.Electricitybill.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table
@Data
public class Customer {
	
	@Id

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@NotEmpty(message="Cannot be empty")
	@Size(min = 12, max = 12, message = "Invalid aadhar Number please enter a vaild aadhar number of 12 digits")
	private String aadharNo;
	@NotNull(message = "First name must not be null..")
	private String firstName;

	private String middleName;
	@NotNull(message = "Last name must not be null..")
	private String lastName;
    
	
	private String gender;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@Pattern(regexp = "^\\d{10}$", message = "Mobile no. should be 10 digit number..")
	private String mobileNo;

}
