package com.littlebank.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class AccountTest {

	private Account testAccount = new Account();
	private int accountNumber = 1234;
	private int balance = 100;
	private int overdraft = 85;
	private int pin = 4321;
	private int withdrawn = 80;
	private int overdrawn = 160;
	
	@BeforeEach
	public void resetTestAccount() {

		testAccount.setAccountNumber(accountNumber);
		testAccount.setBalance(balance);
		testAccount.setOverdraft(overdraft);
		testAccount.setPin(pin);
		
	}
	
	@Test
	public void showAvailableFundsTest() {
		
		assertEquals(balance + overdraft,testAccount.getTotalAvailableFunds());
	}
	
	@Test
	public void updateBalanceWithdrawnTest() {
		testAccount.updateBalance(withdrawn);
		
		assertEquals(20, testAccount.getBalance());
		assertEquals(overdraft, testAccount.getOverdraft());
	}
	
	
	@Test
	public void updateBalanceOverdrawnTest() {
		
		testAccount.updateBalance(overdrawn);
		
		assertEquals(0, testAccount.getBalance());
		assertEquals(25, testAccount.getOverdraft());
	}
	
	
}
