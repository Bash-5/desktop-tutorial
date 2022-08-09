package com.example.Electricitybill.dao;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Electricitybill.bean.Billbean;
import com.example.Electricitybill.bean.Payment;

@Repository
 public interface Billrepo extends CrudRepository<Billbean,Long> {
	 
	 List<Billbean> findByBillId(long billId);
	// Payment savePaymentDetails(Payment payment);
}


	
	
	
