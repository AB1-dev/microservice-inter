package com.example.BankDetails.App;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.BankDetailsApplication;

@RunWith(SpringRunner.class)

@SpringBootTest
class BankDetailsApplicationTest {

	@Test
	void contextLoads() {
		BankDetailsApplication.main(new String[] {});
	}

}
