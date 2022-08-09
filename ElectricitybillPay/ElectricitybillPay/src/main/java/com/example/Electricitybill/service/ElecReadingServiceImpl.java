package com.example.Electricitybill.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Electricitybill.bean.ElecReading;
import com.example.Electricitybill.dao.ElecReadingRepository;

@Service
public class ElecReadingServiceImpl implements ElecReadingService {
	
	@Autowired
	private ElecReadingRepository elecreadingRepository;

	@Override
	public ElecReading saveElecReading(ElecReading elecreading) {
		return elecreadingRepository.save(elecreading);
	}

	@Override
	public List<ElecReading> allElecreading() {
		return elecreadingRepository.findAll();
	}

	@Override
	public ElecReading addElecReading(ElecReading elecreading) {
		return elecreadingRepository.save(elecreading);
	}

	@Override
	public Optional<ElecReading> getElecReadingById(long readingId) {
		return elecreadingRepository.findById(readingId);
	}

	@Override
	public void deleteElecReading(long readingId) {
	    elecreadingRepository.deleteById(readingId);
		
	}

}
