package com.littlebank.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ATMTest {

	private ATM atm = new ATM();
	private String expectedNotesDispensed = "notes dispensed $50 x 1, $20 x 1, $10 x 1, $5 x 1 ";
	
	@BeforeEach
	private void resetATM() {
		atm.setFifty(10);
		atm.setTwenty(2);
		atm.setTen(2);
		atm.setFive(5);
	}
	
	
	
	@Test
	public void dispenseNotesTest(){		
		assertEquals(expectedNotesDispensed, atm.dispenseNotes(85));
	}
	
	@Test
	public void getAvailablefundsTest(){
		assertEquals(585, atm.getAvailablefunds());
	}
}
