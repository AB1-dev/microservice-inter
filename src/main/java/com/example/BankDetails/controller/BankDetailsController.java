package com.example.BankDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankDetails.services.BankServiceImpl;
import com.example.BankDetails.entity.Bank;

@RestController
@RequestMapping("BankService")
public class BankDetailsController {

	@Autowired
	private BankServiceImpl service;

	@GetMapping("/bank")
	public ResponseEntity<List<Bank>> getAllDetails(){
		List<Bank> accounts = service.getAllDetails();
		return new ResponseEntity<List<Bank>>(accounts, HttpStatus.OK);

	}

	@GetMapping("/bank/{id}")
	public ResponseEntity<Bank> getAccountDetails(@PathVariable("id") Integer id){
		Bank account = service.getAccountDetails(id);
		System.out.print("The details:"+account);
		return new ResponseEntity<Bank>(account, HttpStatus.OK);
	}

	@PostMapping("/bank")
	public ResponseEntity<Bank> createAccount(@RequestBody Bank bank){
		Bank b = service.createNewAccount(bank);
		return new ResponseEntity<Bank>(b, HttpStatus.OK);

	}

	@PutMapping("/bank/{Accountnumber}")
	public ResponseEntity<Bank> updateAccount(@PathVariable("Accountnumber") int Accountnumber, @RequestBody Bank bank){

		Bank b = service.updateExistingAccount(Accountnumber, bank);
		return new ResponseEntity<Bank>(b, HttpStatus.OK);
	}


	@PatchMapping("/bank/{Accountnumber}") public ResponseEntity<Bank>
	updateAccount1(@PathVariable("Accountnumber") int Accountnumber, @RequestBody Bank bank){

		Bank b = service.updateExistingAccount(Accountnumber, bank); return new
				ResponseEntity<Bank>(b, HttpStatus.OK); }


	@DeleteMapping("/bank/{Accountnumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable("Accountnumber") int Accountnumber){
		boolean isDeleted = service.deleteAccount(Accountnumber);
		if(isDeleted){
			String responseContent = "This account details have been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting account details from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
