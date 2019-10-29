
package com.example.BankDetails.dao;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace; 
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; 
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; 
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.entity.Bank;

import antlr.collections.List;

@RunWith(SpringRunner.class)

@DataJpaTest

@AutoConfigureTestDatabase(replace=Replace.NONE) 
class BankDAOTest {

	@Autowired 
	private TestEntityManager entitymanager;

	@Autowired 
	private BankDAO dao;

	@Test 
	void testCreateAccount() { 
		Bank bank = getAccountValues(); 
		Bank getFrmDB = dao.createAccount(bank); 
		assertNotNull(getFrmDB.getAccountNumber()); 
	}
	
	@Test
	void testgetAllAccounts()
	{
		java.util.List<Bank> getFrmDB = dao.getAllAccountDetails();
		assertNotNull(getFrmDB.get(0).getAccountNumber());
	}

	private Bank getAccountValues() { 
		Bank bank = new Bank(); 
		bank.setAccountNumber(1238719872); 
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821"); 
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa"); 
		bank.setAmount(235000); return bank; }

}
