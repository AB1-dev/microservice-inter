package com.example.BankDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BankDetails.services.BankServiceImpl;
import com.example.BankDetails.entity.Bank;

@Controller
@RequestMapping("BankService")
public class BookStoreController {
	
	@Autowired
	private BankServiceImpl service;
	
	@GetMapping("bank")
	public ResponseEntity<List<Bank>> getAllDetails(){
		System.out.println("Alert");
		List<Bank> accounts = service.getAllDetails();
		return new ResponseEntity<List<Bank>>(accounts, HttpStatus.OK);
		
	}
	
	@GetMapping("banktotal")
	public ResponseEntity<List<Bank>> gettotalamount(){
		System.out.println("Alert");
		List<Bank> accounts = service.gettotal();
		return new ResponseEntity<List<Bank>>(accounts, HttpStatus.OK);
		
	}
	
	@GetMapping("bank/{id}")
	public ResponseEntity<Bank> getAccountDetails(@PathVariable("id") Integer id){
		Bank account = service.getAccountDetails(id);
		System.out.print("The details:"+account);
		return new ResponseEntity<Bank>(account, HttpStatus.OK);
	}
	
	@PostMapping("bank")
	public ResponseEntity<Bank> createAccount(@RequestBody Bank bank){
		Bank b = service.createNewAccount(bank);
		return new ResponseEntity<Bank>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("bank/{id}")
	public ResponseEntity<Bank> updateAccount(@PathVariable("id") int id, @RequestBody Bank bank){
		
		Bank b = service.updateExistingAccount(id, bank);
		return new ResponseEntity<Bank>(b, HttpStatus.OK);
	}
	
	@PatchMapping("bank/{id}")
	public ResponseEntity<Bank> updateAccount1(@PathVariable("id") int id, @RequestBody Bank bank){
		
		Bank b = service.updateExistingAccount(id, bank);
		return new ResponseEntity<Bank>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("bank/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") int id){
		boolean isDeleted = service.deleteAccount(id);
		if(isDeleted){
			String responseContent = "This account details have been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting account details from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
