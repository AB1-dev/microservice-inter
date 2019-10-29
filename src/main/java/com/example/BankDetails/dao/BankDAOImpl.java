package com.example.BankDetails.dao;

import java.util.List;

import com.example.BankDetails.entity.Bank;

public interface BankDAOImpl {
	
	List<Bank> getAllAccountDetails();
	Bank getAccount(int id);
	Bank createAccount(Bank bank);      
	Bank updateAccount(int id,Bank bank);
	boolean deleteAccount(int id);  

}
