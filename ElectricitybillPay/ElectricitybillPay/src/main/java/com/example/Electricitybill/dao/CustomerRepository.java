package com.example.Electricitybill.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Electricitybill.bean.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{

	Customer findByCustomerId(Long customerId);
	Customer findByEmail(String Email);
	Customer findByAadharNo(String aadharNo);
	List<Customer> findByfirstName(String firstName);
}
