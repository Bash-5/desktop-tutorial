package com.example.Electricitybill.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Electricitybill.bean.Connection;
import com.example.Electricitybill.bean.Customer;
import com.example.Electricitybill.dao.ConnectionRepository;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionRepository connRepo;

	@Override
	public Connection newConnectionRequest(Connection newConnection) {

		return connRepo.save(newConnection);
	}

	@Override
	public Connection findByConsumerNumber(Long consumerNumber) {

		return connRepo.findByConsumerNumber(consumerNumber);

	}

	@Override
	public void saveOrUpdate(Connection connection) {
		
            connRepo.save(connection);
		}

		

	@Override
	public Connection findByConnectionStatus(String connectionStatus){

		return connRepo.findByConnectionStatus(connectionStatus);

	}

}
