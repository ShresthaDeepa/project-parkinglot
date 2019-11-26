package com.app.repository;

import java.time.LocalDateTime;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("Select c from Customer c where c.customerId=:customerId")
	public Customer findByCustomerId(@Param("customerId")String customerId);
	
	
	
	

}
