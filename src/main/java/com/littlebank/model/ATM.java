package com.littlebank.model;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlebank.util.StringConstant;

@Entity
@Table
public class ATM {

	@Id
	@Column
	private int id;

	@Column
	private String location;
	
	@Column
	private int fifty;
	
	@Column
	private int twenty;
	
	@Column
	private int ten;
	
	@Column
	private int five;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getAvailablefunds() {
		
		return (50 * fifty) + (20 * twenty) + (10 * ten) + (5 * five);
	}
	
	public String dispenseNotes(int withdrawlAmount) {
		HashMap<Integer, Integer> dispensedNotes = new HashMap<Integer, Integer>();
		dispensedNotes.put(50, 0);
		dispensedNotes.put(20, 0);
		dispensedNotes.put(10, 0);
		dispensedNotes.put(5, 0);
		
		noteCounter(withdrawlAmount, dispensedNotes);
	
		return String.format(StringConstant.DISPENSED_NOTES_RESPONSE, 
				dispensedNotes.get(50), dispensedNotes.get(20), dispensedNotes.get(10), dispensedNotes.get(5));

	}
	
	private void noteCounter( int withdrawlAmount, HashMap<Integer, Integer> dispensedNotes) {
		 
		 
		 if(withdrawlAmount == 0) {
			 
		 } else if(withdrawlAmount >= 50 && fifty > 0){
			 
			 dispensedNotes.put(50, dispensedNotes.get(50)+1);
			 withdrawlAmount -= 50;
			 fifty -= 1;
			 noteCounter( withdrawlAmount, dispensedNotes);
			 
		 } else if(withdrawlAmount >= 20 && twenty > 0){
			 
			 dispensedNotes.put(20, dispensedNotes.get(20)+1);
			 withdrawlAmount -= 20;
			 twenty -= 1;
			 noteCounter( withdrawlAmount, dispensedNotes);
			 
		 }else if(withdrawlAmount >= 10 && ten > 0){
			
			 dispensedNotes.put(10, dispensedNotes.get(10)+1);
			 withdrawlAmount -= 10;
			 ten -= 1;
			 noteCounter(withdrawlAmount, dispensedNotes);
			 
		 }else if(withdrawlAmount >= 5 && five > 0){
			
			 dispensedNotes.put(5, dispensedNotes.get(5)+1);
			 withdrawlAmount -= 5;
			 five -=1;
			 noteCounter(withdrawlAmount, dispensedNotes);
		 }
		 
	}
	
	
	
	
}
