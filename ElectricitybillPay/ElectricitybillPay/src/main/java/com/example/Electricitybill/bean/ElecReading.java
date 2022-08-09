package com.example.Electricitybill.bean;

import java.time.LocalDate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
@Data
public class ElecReading {
 

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Reading_Id")
	private long readingId;
	
	@Min(50)
	@Column(name="Units_consumed")
	private int unitsConsumed;
	
	@NotNull(message="Reading Date cannot be null")
	@Column(name="Reading_Date")
	private LocalDate readingDate;
	
	@Min(100)
	@Column(name="Price_Per_Unit")
	private int priceperUnit;
	


}
