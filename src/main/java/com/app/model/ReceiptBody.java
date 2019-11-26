package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "receipt_body")
@Component

@NamedNativeQuery(name = "findByTimeInterval", 
									  query = "SELECT SUM(rb.price) FROM receipt_body AS rb LEFT JOIN customer_info AS c ON rb.id = c.receipt_body_id LEFT JOIN duration_info AS d ON c.duration_id = d.id WHERE exit_time LIKE ?", resultClass = ReceiptBody.class)
public class ReceiptBody implements ParkingLotDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5429344229074815105L;
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	@JsonIgnore
	private Long id;
	
	@JsonProperty("parking_hours")
	private String duration;
	
	private Double price;
	
	
		
	public ReceiptBody() {
		
	}
	
	public ReceiptBody(String duration, Double price) {
		super();
		this.duration = duration;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	

}
