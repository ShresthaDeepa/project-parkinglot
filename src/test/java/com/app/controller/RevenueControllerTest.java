package com.app.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.app.model.Customer;
import com.app.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(PowerMockRunner.class)
public class RevenueControllerTest {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private RevenueController revenueController;

	private Customer customer;

	@Before
	public void initialize() {
		customer = new Customer();
		customer.setCustomerId("11");
		customer.setId(1L);
		customer.setDuration(null);
		customer.setPassType("HOURLY");
		customer.setReceiptBody(null);
		customer.setSizeOfVechile("HEAVY");
	}

	@Test
	public void testSaveFailure() throws JsonProcessingException {
		assertTrue("Http Status Code must be 400.", 400 == callMethod().getStatusCodeValue());
	}

	@Test
	public void testSaveSuccess() throws JsonProcessingException {
		/*
		 * PowerMockito.when(customerService.save(Mockito.any(Customer.class))).
		 * thenReturn(customer); ResponseEntity responseEntity =
		 * revenueController.save(customer,bindingResult);
		 * assertTrue("Http Status Code must be 200.", 200 ==
		 * responseEntity.getStatusCodeValue());
		 */
		assertTrue("Http Status Code must be 200", 200 == callMethod(true, true).getStatusCodeValue());
	}

	@SuppressWarnings("rawtypes")
	private ResponseEntity callMethod(boolean... isSave) throws JsonProcessingException {
		BindingResult bindingResult = PowerMockito.mock(BindingResult.class);
		if (!isSave[0]) {
			FieldError error = new FieldError("Customer", "customerid", "Should not be null");
			List<ObjectError> errorList = new ArrayList<>();
			errorList.add(error);

			PowerMockito.when(bindingResult.hasErrors()).thenReturn(isSave[1]);
			if (isSave[3]) {
				PowerMockito.when(bindingResult.getAllErrors()).thenReturn(errorList);
			}else {
				PowerMockito.when(bindingResult.getAllErrors()).thenReturn(new ArrayList<>());
			}
		}
		PowerMockito.when(customerService.save(Mockito.any(Customer.class))).thenReturn(customer);
		return revenueController.save(customer, bindingResult);
	}

}
