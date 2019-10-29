
package com.example.BankDetails.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace; 
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; 
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.entity.Bank;

@RunWith(SpringRunner.class)

@DataJpaTest

@AutoConfigureTestDatabase(replace=Replace.NONE) 
class BankDAOTest {

	@Autowired 
	private BankDAO dao;
	
	@Test
	void testgetAllAccounts()
	{
		List<Bank> l1 = new ArrayList<Bank>();
		l1 = dao.getTotalAmount();
		assertNotNull(l1);
	}
}
