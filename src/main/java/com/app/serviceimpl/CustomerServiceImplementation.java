package com.app.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ReceiptServiceImpl receiptServiceImpl;

	@Override
	public Customer save(Customer customer) {		
		return customerRepository.save(customer);
	}

	

	@Override
	public Customer update(Customer customer) {
		Customer OldcustomerInfo = customerRepository.findByCustomerId(customer.getCustomerId());
		if(OldcustomerInfo!= null) {
			OldcustomerInfo.getDuration().setExitTime(customer.getDuration().getExitTime());
			OldcustomerInfo.setReceiptBody(receiptServiceImpl.createReceipt(OldcustomerInfo));
		}
		
		return customerRepository.save(OldcustomerInfo);
		
	}



	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
