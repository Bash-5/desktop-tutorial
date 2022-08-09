package com.example.Electricitybill.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Electricitybill.bean.Billbean;
import com.example.Electricitybill.bean.Customer;
import com.example.Electricitybill.exception.NoSuchCustomerException;
import com.example.Electricitybill.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/hello")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("hi hello bye", HttpStatus.OK);
	}

	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody @Valid Customer customer) {
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), HttpStatus.CREATED);
	}// working

	@GetMapping("/byId/{id}")
	public ResponseEntity<Customer> viewCustomerProfile(@PathVariable(value = "id") Long customerId) {
		return new ResponseEntity<Customer>(customerService.viewCustomerProfile(customerId), HttpStatus.OK);
	}

	@GetMapping("/byemail/{email}")
	public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable(value = "email") String email) {
		if(customerService.findByEmail(email)==null){
			   System.out.println("Email Not found");
			   throw new NoSuchCustomerException();
			   
		}
	 
		 System.out.println("Fetched Successfully");
		   return new ResponseEntity<Customer>(customerService.findByEmail(email),HttpStatus.OK); 
		
	}

	@GetMapping("/byaadharNo/{aadharNo}")
	public ResponseEntity<Customer> searchCustomerByAadhar(@PathVariable(value = "aadharNo") String aadharNo) {
		if(customerService.findByAadharNo(aadharNo)==null){
			   System.out.println("aadhar Not found");
			   throw new NoSuchCustomerException();
			   
		}
	 
		 System.out.println("Fetched Successfully");
		    return new ResponseEntity<Customer>(customerService.findByAadharNo(aadharNo),HttpStatus.OK);
	}

	@GetMapping("/byname/{firstName}")
	public ResponseEntity<List<Customer>> searchCustomerByName(@PathVariable(value = "firstName") String firstName) {
		if(customerService.findByfirstName(firstName)==null){
			   System.out.println("FirstName Not found");
			   throw new NoSuchCustomerException();
			   
		}
	 
		 System.out.println("Fetched Successfully");
		    return new ResponseEntity<List<Customer>>(customerService.findByfirstName(firstName),HttpStatus.OK);
	}

	@PutMapping("/editdetails/{id}")
	private Customer update(@RequestBody Customer customer)  {
	       customerService.saveOrUpdate(customer);  
	return customer;  
	}


}
