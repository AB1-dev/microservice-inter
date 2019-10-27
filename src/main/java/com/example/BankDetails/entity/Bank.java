package com.example.BankDetails.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="bank")
public class Bank implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="Accountnumber")
	private int Accountnumber;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Firstname")
	private String Firstname;
	
	@Column(name="Lastname")
	private String Lastname;
	
	@Column(name="Phone")
	private String Phone;
	
	@Column(name="Address1")
	private String Address1;
	
	@Column(name="Address2")
	private String Address2;
	
	@Column(name="Amountbalance")
	private int Amountbalance;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return Accountnumber;
	}

	public void setAccountNumber(int accountNumber) {
		Accountnumber = accountNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getFirstName() {
		return Firstname;
	}

	public void setFirstName(String firstName) {
		this.Firstname = firstName;
	}

	public String getLastName() {
		return Lastname;
	}

	public void setLastName(String lastName) {
		this.Lastname = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		this.Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		this.Address2 = address2;
	}
	
	public int getAmount() {
		return Amountbalance;
	}

	public void setAmount(int amount) {
		this.Amountbalance = amount;
	}


	

	

	

}
