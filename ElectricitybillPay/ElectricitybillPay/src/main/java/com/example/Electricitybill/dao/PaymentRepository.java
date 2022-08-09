package com.example.Electricitybill.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.Electricitybill.bean.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	
	Payment findBypaymentId(Long paymentId);
}
