package com.littlebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlebank.util.StringConstant;

@Entity
@Table
public class Account {

	@Id
	@Column
	private int accountNumber;
	
	@Column
	private int pin;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int balance;
	
	@Column
	private int overdraft;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}
	
	public String showAvailableFunds() {
		
		return String.format(StringConstant.ACCOUNT_BALANCE_RESPONSE, balance, overdraft);
	}
	
	public int getTotalAvailableFunds() {
		return balance + overdraft;
	}
	
	public void updateBalance(int withdrawn) {		
		int overdrawnAmount;
		
		if(balance >= withdrawn) {
			
			balance -= withdrawn;
			
		} else if(balance < withdrawn) {
			
			overdrawnAmount = withdrawn - balance;
			balance = 0;
			
			overdraft -= overdrawnAmount;
		}
	}
}
