package com.littlebank.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.littlebank.model.Account;

@DataJpaTest
@AutoConfigureTestDatabase
public class AccountRepositoryTest {

	
	 @Autowired
	   private TestEntityManager entityManager;

	   @Autowired
	   private AccountRepository accountRepository;
	   
	   @Test
	   public void findById() {
	       int firstAccountId = 123456789;
	       int secondAccountId = 987654321;
		   
	       Account firstAccount = new Account();
	       firstAccount.setAccountNumber(firstAccountId);
	       entityManager.persist(firstAccount);
	       entityManager.flush();
	       
	       Account secondAccount = new Account();
	       secondAccount.setAccountNumber(secondAccountId);
	       entityManager.persist(secondAccount);
	       entityManager.flush();

	      Account foundAccount = accountRepository.findById(secondAccountId).get();

	       
	       assert(foundAccount != null);
	       assertEquals(secondAccountId, foundAccount.getAccountNumber());
	   }
	
}
