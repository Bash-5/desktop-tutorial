package com.example.Electricitybill.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Electricitybill.bean.Billbean;

import com.example.Electricitybill.dao.Billrepo;

import com.example.Electricitybill.exception.NoSuchCustomerException;

@Service
@Transactional
public class BillServiceImpl implements Billservice {

	@Autowired

	private Billrepo billRepo;

	public List<Billbean> getAllBill() {
		List<Billbean> bills = new ArrayList<Billbean>();
		billRepo.findAll().forEach(bill -> bills.add(bill));
		return bills;
	}

	public List<Billbean> findById(long billId) {
		return (List<Billbean>) billRepo.findByBillId(billId);
	}

	public void saveOrUpdate(Billbean billBean) {
		billRepo.save(billBean);
	}

	public int deleteById(long billId) {
		if (billRepo.existsById(billId)) {

			billRepo.deleteById(billId);
			return 1;
		} else {
			throw new NoSuchCustomerException();
		}

	}

	public void update(Billbean billBean, long billId) {
		billRepo.save(billBean);
	}

}
