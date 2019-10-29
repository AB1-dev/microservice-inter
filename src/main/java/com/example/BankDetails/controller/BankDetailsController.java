package com.example.BankDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankDetails.services.BankServiceImpl;
import com.example.BankDetails.entity.Bank;

@RestController
@RequestMapping("BankService")
public class BankDetailsController {

	@Autowired
	private BankServiceImpl service;

	@GetMapping("/banktotal")
	public ResponseEntity<List<Bank>> getTotalAmountDetails(){
		List<Bank> accounts = service.getTotalAmount();
		return new ResponseEntity<List<Bank>>(accounts, HttpStatus.OK);

	}

	

}
