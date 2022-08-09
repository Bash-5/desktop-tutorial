package com.example.Electricitybill.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Electricitybill.bean.Billbean;

import com.example.Electricitybill.exception.NoSuchCustomerException;
import com.example.Electricitybill.service.Billservice;

@RestController
public class Billcontroller {
@Autowired
	Billservice billService;
    Billbean billBean;

@GetMapping("/bill")  
private List<Billbean> getAllBill()   
{  
	   
    return billService.getAllBill();
}

@GetMapping("/billid/{billId}")

public List<Billbean> getbillid(@PathVariable("billId") long billId)
{ 
			
   if(billService.findById(billId).isEmpty()){
		   System.out.println("Bill Not found");
		   throw new NoSuchCustomerException();
		   
	}
 
	 System.out.println("Fetched Successfully");
	   return billService.findById(billId); 
}

@DeleteMapping("/billid/{billId}") 
public String deletebillid(@PathVariable("billId") long billId)
{ 
	 billService.deleteById(billId);
      return "deleted Successfully";
}  

@PostMapping("/bill")  
private long saveOrUpdate(@RequestBody Billbean billbean)   
{  
billService.saveOrUpdate(billbean);  
return billbean.getBillId();  
} 

@PutMapping("/bills")  
private Billbean update(@RequestBody Billbean billbean)   
{  
	billService.saveOrUpdate(billbean);  
	return billbean;  
}  

}  



