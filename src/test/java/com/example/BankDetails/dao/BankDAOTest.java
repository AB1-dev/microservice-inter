
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
	
	@Test
	void testgetAccountById()
	{
		Bank bank = getAccountValues();
		Bank setToDB = entitymanager.persist(bank);
		Bank getFrmDB = dao.getAccount(bank.getAccountNumber());
		assertEquals(setToDB.getAccountNumber(),getFrmDB.getAccountNumber());
	}
	
	@Test
	void testUpdateAccount()
	{
		Bank bank1 = new Bank(); 
		//bank1.setId(1);
		bank1.setAccountNumber(1238719872); 
		bank1.setEmail("sandy@gmail.com");
		bank1.setFirstName("sandeep");
		bank1.setLastName("Manohar DAS");
		bank1.setPhone("9090822"); 
		bank1.setAddress1("cuttak");
		bank1.setAddress2("orissa"); 
		bank1.setAmount(235000);
		
		Bank bank = getAccountValues();
		Bank setToDB = entitymanager.persist(bank);
		Bank getFrmDB = dao.updateAccount(bank.getAccountNumber(), bank1);
		assertEquals("9090822",getFrmDB.getPhone());
	}
	
	@Test
	void testDeleteAccount()
	{
		Bank bank = getAccountValues();
		Bank bank1 = dao.createAccount(bank);
		//Bank storeToDB = entitymanager.persist(bank);
		Boolean getFrmDB = dao.deleteAccount(bank1.getAccountNumber());
		
		//assertNotNull(getFrmDB.getAccountNumber());
		assertEquals(true, getFrmDB);
	}

	private Bank getAccountValues() { 
		Bank bank = new Bank(); 
		//bank.setId(1);
		bank.setAccountNumber(1238719872); 
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821"); 
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa"); 
		bank.setAmount(235000); return bank; }

}
