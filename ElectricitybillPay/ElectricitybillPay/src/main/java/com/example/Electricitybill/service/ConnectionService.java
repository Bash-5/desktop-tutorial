package com.example.Electricitybill.service;
import com.example.Electricitybill.bean.Connection;



public interface ConnectionService {
	
	
	public Connection newConnectionRequest(Connection newConnection);

	public Connection findByConsumerNumber(Long consumerNumber);

    void  saveOrUpdate(Connection connection);
	
	public Connection findByConnectionStatus(String connectionStatus);
	

	

}

