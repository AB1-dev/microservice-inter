package com.example.BankDetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankDetails.dao.BankDAOImpl;
import com.example.BankDetails.entity.Bank;


@Service
public class BankService implements BankServiceImpl {
	
	@Autowired
	private BankDAOImpl dao;


	@Override
	public List<Bank> getAllDetails() {
		// TODO Auto-generated method stub
		System.out.println("Alert3434");
		return dao.getAllAccountDetails();
	}

	@Override
	public Bank createNewAccount(Bank bank) {
		// TODO Auto-generated method stub
		return dao.createAccount(bank);
	}

	@Override
	public Bank updateExistingAccount(int id, Bank bank) {
		// TODO Auto-generated method stub
		return dao.updateAccount(id, bank);
	}

	@Override
	public Bank getAccountDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getAccount(id);
	}

	@Override
	public boolean deleteAccount(int id) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(id);
	}

}
