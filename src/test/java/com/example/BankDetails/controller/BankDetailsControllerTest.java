package com.example.BankDetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankDetails.controller.BankDetailsController;
import com.example.BankDetails.entity.Bank;
import com.example.BankDetails.services.BankServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
/* @WebMvcTest(BankDetailsController.class) */
@SpringBootTest
@AutoConfigureMockMvc
public class BankDetailsControllerTest {

	@Autowired 
	private MockMvc mvc;

	@MockBean
	BankServiceImpl service;

	@Test
	public void retrieveAccountDetails() throws Exception {

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


		Mockito.when(
				service.getAllDetails()).thenReturn(l1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/BankService/bank/1").accept(MediaType.APPLICATION_JSON);


		MvcResult result = mvc.perform(requestBuilder).andReturn(); String
		expectedJson = this.mapToJson(bank); String outputJson =
		result.getResponse().getContentAsString();
		assertThat(outputJson.equals(expectedJson));

		/*
		 * ResponseEntity<List<Bank>> resp = ctl.getAllDetails();
		 * assertEquals(200,resp.getStatusCodeValue());
		 */

	}

	@Test
	public void retrieveSingleAccount() throws Exception {

		Bank  bank = new Bank();

		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);

		Mockito.when(
				service.getAccountDetails(Mockito.anyInt())).thenReturn(bank);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/BankService/bank/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(bank);
		String outputJson = result.getResponse().getContentAsString();
		assertThat(outputJson.equals(expectedJson));
	}


	@Test
	public void createAccount() throws Exception {

		Bank  bank = new Bank();

		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);

		String inputInJSON = this.mapToJson(bank);

		Mockito.when(
				service.createNewAccount(
						Mockito.any(Bank.class))).thenReturn(bank);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/BankService/bank")
				.accept(MediaType.APPLICATION_JSON).content(inputInJSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String outputJson = response.getContentAsString();
		assertThat(outputJson.equals(inputInJSON));

		assertEquals(200, response.getStatus());
	}

	@Test
	public void DeleteAccount() throws Exception {

		Mockito.when(
				service.deleteAccount(Mockito.anyInt())).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/BankService/bank/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

	}

	@Test
	public void UpdateAccount() throws Exception {

		Bank  bank = new Bank();

		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);

		String inputInJSON = this.mapToJson(bank);

		Mockito.when(
				service.updateExistingAccount(Mockito.anyInt(),Mockito.any(Bank.class))).thenReturn(bank);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/BankService/bank/3").content(inputInJSON)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String outputJson = response.getContentAsString();
		assertThat(outputJson.equals(inputInJSON));

		assertEquals(200, response.getStatus());

	}

	@Test
	public void PatchAccount() throws Exception {

		Bank  bank = new Bank();

		bank.setAccountNumber(1238719872);
		bank.setId(2);
		bank.setEmail("sandy@gmail.com");
		bank.setFirstName("sandeep");
		bank.setLastName("Manohar DAS");
		bank.setPhone("9090821");
		bank.setAddress1("cuttak");
		bank.setAddress2("orissa");
		bank.setAmount(235000);

		String inputInJSON = this.mapToJson(bank);

		Mockito.when(
				service.updateExistingAccount(Mockito.anyInt(),Mockito.any(Bank.class))).thenReturn(bank);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/BankService/bank/3").content(inputInJSON)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

	}

	private String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper objectmapper = new ObjectMapper();
		return objectmapper.writeValueAsString(obj);
	}





}
