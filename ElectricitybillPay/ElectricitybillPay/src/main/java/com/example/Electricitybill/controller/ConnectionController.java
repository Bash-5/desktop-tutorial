package com.example.Electricitybill.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Electricitybill.bean.Connection;
import com.example.Electricitybill.bean.Customer;
import com.example.Electricitybill.service.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	
	@PostMapping("/saveConnection")
	public ResponseEntity<Connection> newConnectionRequest(@RequestBody @Valid Connection connection)
	{
		return new ResponseEntity<Connection>(connectionService.newConnectionRequest(connection), HttpStatus.CREATED);
	}
	
	@GetMapping("/searchByConsumerNumber/{consumerNumber}")
	public ResponseEntity<Connection> searchByConsumerNumber(@PathVariable(value = "consumerNumber") Long consumerNumber)
	{
		return new ResponseEntity<Connection>(connectionService.findByConsumerNumber(consumerNumber),HttpStatus.OK);
		
	}
	
	@PutMapping("/modifyConnection/{connectionId}")
	private Connection update(@RequestBody Connection connection)  {
	       connectionService.saveOrUpdate(connection);  
	return connection;  
	}	

	@GetMapping("/searchByConnectionStatus/{connectionStatus}")
	public ResponseEntity<Connection> searchConnectionStatus(@PathVariable(value = "connectionStatus") String connectionStatus)
	{
		return new ResponseEntity<Connection>(connectionService.findByConnectionStatus(connectionStatus),HttpStatus.OK);
		
	}
	

}
