package com.example.Electricitybill.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Electricitybill.bean.Billbean;
import com.example.Electricitybill.bean.Customer;
import com.example.Electricitybill.dao.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	public Customer viewCustomerProfile(Long customerId) {

		return customerRepository.findByCustomerId(customerId);

	}

   @Override
	public Customer findByEmail(String email) {

		return  customerRepository.findByEmail(email);

	}

	@Override
	public Customer findByAadharNo(String aadharNo) {

		return customerRepository.findByAadharNo(aadharNo);
		

	}

    @Override
	public List<Customer> findByfirstName(String firstName) {

		List<Customer> customer = customerRepository.findByfirstName(firstName);
		return customer;

	}

	@Override
	public void saveOrUpdate(Customer customer) {
             customerRepository.save(customer);
		}
		
		
		

}
