package com.app.service;

import java.util.List;


import com.app.model.Customer;

public interface CustomerService{
	
	public Customer save(Customer customer);
	
	public Customer update(Customer customer);
	public List<Customer> findAll();
}
