package com.example.Electricitybill.bean;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import lombok.Data;

@Entity
@Table
@Data

public class Billbean {
	
	  @Id
	  
	  private long billId;
	  Date BillDate= new Date();
	  Date BillDueDate= new Date();
	  private int unitsConsumed;
	  private int billAmount;

}
