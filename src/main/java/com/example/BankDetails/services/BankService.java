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
	public List<Bank> getTotalAmount() {
		// TODO Auto-generated method stub
		return dao.getTotalAmount();
	}


	

}
