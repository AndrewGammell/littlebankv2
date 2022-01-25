package com.littlebank.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlebank.exception.InvalidLoginException;
import com.littlebank.model.Account;
import com.littlebank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	//TODO figure out why data.sql is not populating table
	private boolean isDataInitalized = false;
	private  void createInitalAccounts() {
		Account account;
		
		account = new Account();
		account.setAccountNumber(123456789);
		account.setBalance(800);
		account.setFirstName("john");
		account.setLastName("doe");
		account.setPin(1234);
		account.setOverdraft(200);
		createAccount(account);
		
		account = new Account();
		account.setAccountNumber(987654321);
		account.setBalance(1230);
		account.setFirstName("john");
		account.setLastName("doe");
		account.setPin(4321);
		account.setOverdraft(150);
		createAccount(account);
		isDataInitalized = true;
	}
	
	public boolean isvalidLogin(int accountNumber, int pin) throws  InvalidLoginException{
		if(!isDataInitalized) {
			createInitalAccounts();
		}
		
		try {
			return accountRepository.findById(accountNumber).get().getPin() == pin;
		}catch (NoSuchElementException nsee){
			throw new InvalidLoginException("Could not find account with these credentials");
		}
		
	}
	
	public boolean createAccount(Account account) {
		
		return !accountRepository.save(account).equals(null);
	}
	
	public String getBalance(int accountNumber) {
		
		return	accountRepository.findById(accountNumber).get().showAvailableFunds();
		
	}
	
	public Account getAccount(int accountNumber) {
		
		return accountRepository.findById(accountNumber).get();
		
	}
	
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}
	
}
