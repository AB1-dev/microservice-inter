package com.example.BankDetails.services;

import static org.assertj.core.api.Assertions.assertThat;

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
	void testTotalAmount() {
		
		Bank bank1 = new Bank();
		
		bank1.setEmail("sandy@gmail.com");
		bank1.setFirstName("sandeep");
		bank1.setLastName("Manohar DAS");
		bank1.setPhone("9090821");
		bank1.setAmount(235000);
		List<Bank> l1 = new ArrayList<Bank>();
		l1.add(bank1);
		
		Mockito.when(dao.getTotalAmount()).thenReturn(l1);
		assertThat(service.getTotalAmount().equals(l1));
	}
	
}
