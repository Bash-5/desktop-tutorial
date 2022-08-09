package com.example.Electricitybill.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Electricitybill.bean.Billbean;
import com.example.Electricitybill.bean.Customer;
import com.example.Electricitybill.bean.Payment;
import com.example.Electricitybill.exception.AmountExceededException;
import com.example.Electricitybill.dao.Billrepo;
import com.example.Electricitybill.dao.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	Billrepo billRepository;

	@Override
	public Payment findBypaymentId(Long paymentId) {
		return  paymentRepository.findBypaymentId(paymentId);
	}
	

/*	@Override
	public Payment savePaymentDetails(Payment payment) {
		Billbean bill = billRepository.savePaymentDetails(payment.getBillId());
		if (bill.getBillAmount() == payment.getTotalPaid()) {
			payment.setStatus("Paid");
			return paymentRepository.save(payment);
		} else if (bill.getBillAmount() >= payment.getTotalPaid()) {
			payment.setStatus("UnPaid");
			return paymentRepository.save(payment);
		} else

			throw new AmountExceededException();

	}*/

	@Override
	public String deletePayment(Long paymentId) {

		paymentRepository.deleteById(paymentId);
		return "Deleted Successfully";
	}

}
