package com.example.Electricitybill.service;

import com.example.Electricitybill.bean.Payment;



public interface PaymentService {
	
//	public Payment saveOrUpdate(Payment payment);
	//public Payment viewPaymentProfile(Long paymentId);
    public Payment findBypaymentId(Long paymentId);
	public String deletePayment(Long paymentId);
	
}
