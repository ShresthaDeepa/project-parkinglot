package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.TimeInterval;
import com.app.service.CustomerService;
import com.app.service.ReceiptService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin
@RestController
@SuppressWarnings("rawtypes")
public class RevenueController {
	
	@Autowired
	private CustomerService customerService;	
	
	@Autowired
	private ReceiptService receiptService;
	
	
	@RequestMapping( value = "/entry_information", method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody  @Valid Customer customer,  BindingResult bindingResult) throws JsonProcessingException {
		/*ObjectMapper mapper = new ObjectMapper();
		ObjectNode obj = mapper.createObjectNode();
		obj.put("message", "successfull");
		return ResponseEntity.ok(mapper.writeValueAsString(obj));*/	
		System.out.println("Entry Info being called");
		if(bindingResult.hasErrors()) {
			Map<String,String> errorInfo = new HashMap<>();
			
			for(ObjectError error:bindingResult.getAllErrors()) {
				
				if(error instanceof FieldError) {
					errorInfo.put(((FieldError)error).getField(), error.getDefaultMessage());
				}
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
		}
		
		
		return Objects.nonNull(customerService.save(customer))?
				ResponseEntity.ok(HttpStatus.OK): ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
		/*return ResponseEntity.ok(HttpStatus.OK);*/
	}
	
	@RequestMapping(value = "/update_exit_time", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity updateExitTime(@RequestBody Customer customer){
		Customer updatedCustomer = customerService.update(customer);
		
		return Objects.nonNull(updatedCustomer)? 
				ResponseEntity.ok(updatedCustomer): ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@RequestMapping(value = "/sales_result", method = {RequestMethod.POST})
	public ResponseEntity getTotalSales(@RequestBody TimeInterval timeInterval) {		
		
		
		return ResponseEntity.ok(receiptService.saveTimeInterval(timeInterval));
		
	}
	
	@RequestMapping(value="/customers", method = {RequestMethod.GET})
	public ResponseEntity getAllCustomers() {
		
		List<Customer> customerList = customerService.findAll();
		System.out.println("Sending list of Customers");
		return ResponseEntity.ok(customerList);
	}

}
