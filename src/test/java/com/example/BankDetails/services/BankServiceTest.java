package com.example.BankDetails.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.dao.BankDAO;
import com.example.BankDetails.entity.Bank;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceTest {
	
	@Autowired
	private BankService service;
	
	@MockBean
	private BankDAO dao;

	@Test
	void testCreateAccount() {
		Bank bank  = new Bank();
		
		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);
		
		Mockito.when(dao.createAccount(bank)).thenReturn(bank);
		assertThat(service.createNewAccount(bank).equals(bank));
	}
	
	@Test
	void testGetAccountById() {
		Bank bank  = new Bank();
		
		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);
		
		Mockito.when(dao.getAccount(2)).thenReturn(bank);
		assertThat(service.getAccountDetails(2).equals(bank));
	}
	
	@Test
	void testGetAllAccounts() {
		Bank bank  = new Bank();
		
		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);
		
		Bank bank1 = new Bank();
		
		bank1.setAccountNumber(1238719872);
		bank1.setId(2);
		bank1.setEmail("sandy@gmail.com");
		bank1.setFirstName("sandeep");
		bank1.setLastName("Manohar DAS");
		bank1.setPhone("9090821");
		bank1.setAddress1("cuttak");
		bank1.setAddress2("orissa");
		bank1.setAmount(235000);
		List<Bank> l1 = new ArrayList<Bank>();
		l1.add(bank);
		l1.add(bank1);
		
		Mockito.when(dao.getAllAccountDetails()).thenReturn(l1);
		assertThat(service.getAllDetails().equals(l1));
	}
	
	@Test
	void testDeleteAccountDetails() {
		Bank bank  = new Bank();
		
		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);
		
		Mockito.when(dao.deleteAccount(2)).thenReturn(true);
		assertEquals(true,service.deleteAccount(2));
	}
	
	@Test
	void testUpdateAccountDetails() {
		Bank bank  = new Bank();
		
		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@Yahoo.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);
		
		Mockito.when(dao.updateAccount(2,bank)).thenReturn(bank);
		assertThat(service.updateExistingAccount(2, bank).equals(bank));
	}
	
	

}
