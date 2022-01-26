package com.littlebank.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.h2.engine.Database;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import com.littlebank.model.Account;
import com.littlebank.service.AccountService;

@ContextConfiguration( classes = TestConfiguration.class )
public class AccountServiceTest {

	
	@Mock
    Database database;
    @Mock
    Account account;
    @Mock
    AccountRepository accountRepository;
    
    
 
    @Autowired
    @InjectMocks
    @Qualifier("accountService")
    AccountService accountService;
    
//    @Test
    public void createAccount() {

        Account createAccount = new Account();
        account.setAccountNumber(101010);
        
        accountService.createAccount(createAccount);

        Account foundAccount = accountService.getAccount(101010);
        
       assertEquals(101010, foundAccount.getAccountNumber());
    }
}
