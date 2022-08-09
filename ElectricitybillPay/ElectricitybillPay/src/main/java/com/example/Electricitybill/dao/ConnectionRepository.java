package com.example.Electricitybill.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Electricitybill.bean.Connection;


@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String> {

	Connection findByConsumerNumber(Long ConsumerNumber);
	Connection findByConnectionStatus(String ConnectionStatus);
	 
}
