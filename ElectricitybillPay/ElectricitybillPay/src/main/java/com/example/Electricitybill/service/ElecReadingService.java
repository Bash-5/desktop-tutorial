package com.example.Electricitybill.service;

import java.util.List;

import java.util.Optional;

import com.example.Electricitybill.bean.ElecReading;

public interface ElecReadingService {

public ElecReading saveElecReading(ElecReading elecreading);
	
	public List<ElecReading> allElecreading();
	
	public Optional<ElecReading> getElecReadingById(long readingId);
	
	public ElecReading addElecReading(ElecReading elecreading);
	
	void deleteElecReading(long readingId);

}
