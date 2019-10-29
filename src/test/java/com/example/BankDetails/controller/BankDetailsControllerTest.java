package com.example.BankDetails.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.controller.BankDetailsController;
import com.example.BankDetails.entity.Bank;
import com.example.BankDetails.services.BankServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(BankDetailsController.class)
public class BankDetailsControllerTest {

	@Autowired 
	private MockMvc mvc;

	@MockBean
	BankServiceImpl service;

	@Test
	public void retrieveTotalAmount() throws Exception {

		Bank bank1 = new Bank();

		bank1.setEmail("sandy@gmail.com");
		bank1.setFirstName("sandeep");
		bank1.setLastName("Manohar DAS");
		bank1.setPhone("9090821");
		bank1.setAmount(235000);
		List<Bank> l1 = new ArrayList<Bank>();
		l1.add(bank1);


		Mockito.when(
				service.getTotalAmount()).thenReturn(l1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/BankService/banktotal").accept(MediaType.APPLICATION_JSON);


		MvcResult result = mvc.perform(requestBuilder).andReturn(); 
		String expectedJson = this.mapToJson(bank1); 
		String outputJson = result.getResponse().getContentAsString();
		assertThat(outputJson.equals(expectedJson));

	}

	private String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper objectmapper = new ObjectMapper();
		return objectmapper.writeValueAsString(obj);
	}





}
