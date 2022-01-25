package com.littlebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlebank.model.ATM;
import com.littlebank.repository.AtmRepository;

@Service
public class AtmService {

	@Autowired
	AtmRepository atmRepository;
	
	private int atmId = 111;
	
	public ATM getAtm() {
		
		if(atmRepository.count() == 0) {
			initalizeAtmData();
		}
		
		return atmRepository.findById(atmId).get();
	}
	
	//TODO figure out why data.sql is not populating table
	private void initalizeAtmData() {
		ATM atm = new ATM();
		
		atm.setFifty(10);
		atm.setTwenty(30);
		atm.setTen(30);
		atm.setFive(20);
		atm.setLocation("metaverse");
		atm.setId(atmId);
		
		atmRepository.save(atm);
	}
	
	public void updateAtm(ATM atm) {
		atmRepository.save(atm);
	}
	
	
	
	
	
}
