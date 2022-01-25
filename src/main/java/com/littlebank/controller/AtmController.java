package com.littlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.littlebank.exception.InvalidLoginException;
import com.littlebank.exception.InvalidWithdrawlException;
import com.littlebank.model.ATM;
import com.littlebank.model.Account;
import com.littlebank.service.AccountService;
import com.littlebank.service.AtmService;
import com.littlebank.util.StringConstant;

@RestController
public class AtmController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AtmService atmService;
	
	private String response;
	
	@GetMapping("/")
	public String greetings() {
		
		return StringConstant.WELCOME;
	}
	
	
	@PostMapping("/login")
	public boolean login(@RequestHeader(value = "accountNumber") int accountNumber, @RequestHeader(value = "pin") int pin) {

		try {
			return accountService.isvalidLogin(accountNumber, pin);
		} catch (InvalidLoginException ile) {
			ile.printStackTrace();
		}
		
		return false;
	}
	
	@PutMapping("/withdrawl")
	public String withdrawFunds(@RequestHeader(value = "accountNumber") int accountNumber, @RequestHeader(value = "pin") int pin, @RequestHeader(value = "amount") int amount) {
		String response = "no account found";
		Account withdrawlAccount;
		ATM atm;
		
		try {
				if(login(accountNumber, pin)) {
					withdrawlAccount = accountService.getAccount(accountNumber);
					atm = atmService.getAtm();
					
					try {
						validateWithdrawl(withdrawlAccount, atm, amount);
						withdrawlAccount.updateBalance(amount);
						response = atm.dispenseNotes(amount).concat(String.format(StringConstant.ACCOUNT_BALANCE_RESPONSE, 
																		withdrawlAccount.getBalance(), withdrawlAccount.getOverdraft()));
	
						atmService.updateAtm(atm);
						accountService.updateAccount(withdrawlAccount);
						
					} catch (InvalidWithdrawlException iwe) {
						response = iwe.getMessage();
						iwe.printStackTrace();
					}
				}
			} catch(InvalidLoginException ile) {
				ile.printStackTrace();
				response = ile.getMessage();
			}
		
		
		return response;
	}
	
	@GetMapping("/balance")
	public String getAccountBalance(@RequestHeader(value = "accountNumber") int accountNumber, @RequestHeader(value = "pin") int pin) {
		
		try {
			if(login(accountNumber, pin)) {
				response = accountService.getBalance(accountNumber);
			} 
		}catch(InvalidLoginException ile){
			ile.printStackTrace();
			response = ile.getMessage();
		}
		
		return response;
	}
	
	public void validateWithdrawl(Account account, ATM atm, int amount) throws InvalidWithdrawlException {
		
		if(account.getTotalAvailableFunds() < amount) {
			throw new InvalidWithdrawlException(String.format(StringConstant.OVER_WITHDRAWL_RESPONSE, amount, account.getTotalAvailableFunds()));
		}
		
		if(amount % 5 != 0) {
			throw new InvalidWithdrawlException(StringConstant.ODD_NUMBER_WITHDRAWL_RESPONSE);

		}
		
		if (amount > atm.getAvailablefunds()) {
			throw new InvalidWithdrawlException(String.format(StringConstant.ATM_FUNDS_LOW, atm.getAvailablefunds()));
		}
		
	}
	
}
