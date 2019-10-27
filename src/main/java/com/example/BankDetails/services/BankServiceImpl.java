package com.example.BankDetails.services;

import java.util.List;

import com.example.BankDetails.entity.Bank;

public interface BankServiceImpl {
	
	List<Bank> getAllDetails();
	Bank createNewAccount(Bank bank);
	Bank updateExistingAccount(int id, Bank bank);
	Bank getAccountDetails(int id);
	boolean deleteAccount(int id);
	List<Bank> gettotal();

}
