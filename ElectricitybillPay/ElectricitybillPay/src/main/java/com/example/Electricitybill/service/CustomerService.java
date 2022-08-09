package com.example.Electricitybill.service;

import java.util.List;

import com.example.Electricitybill.bean.Customer;


public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);	
	public Customer viewCustomerProfile(Long customerId);
	public Customer findByEmail(String email);
	public Customer findByAadharNo(String aadharNo);
	public List<Customer> findByfirstName(String firstName);
	public void saveOrUpdate(Customer customer); 
	

}
