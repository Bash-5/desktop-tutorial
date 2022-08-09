package com.example.Electricitybill.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import com.example.Electricitybill.bean.Billbean;



import org.springframework.stereotype.Service;

@Service

public interface Billservice {
	@Autowired
   
	 public List<Billbean> getAllBill();   
	 public List<Billbean> findById(long billId);
	 public void saveOrUpdate(Billbean billBean); 
	 public int deleteById(long billId);   
	 public void update(Billbean billBean, long billId);   
	
	
	
}
