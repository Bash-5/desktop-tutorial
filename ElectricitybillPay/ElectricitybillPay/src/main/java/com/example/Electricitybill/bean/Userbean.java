package com.example.Electricitybill.bean;

import lombok.Data;


import javax.persistence.*;
//port javax.persistence.Table;
//port javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
@Table
public class Userbean{
    @Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;

	@Column(unique = true)
	@NotNull(message = "Username must not be null..")
	private String userName;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password constraints not satisfied!")
	private String password;
   
	}
