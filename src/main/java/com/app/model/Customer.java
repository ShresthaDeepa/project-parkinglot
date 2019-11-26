package com.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@Entity
@Table(name="customer_info")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
	"customerId","passType","sizeOfVechile","duration"
})
public class Customer implements ParkingLotDomain{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2234580903325211929L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonIgnore
	private Long id;
	
	@JsonProperty(value = "customer_id")
	@Column(name = "customer_id")
	@Size(min=2, message= "Customer ID should be at least 2 characters")
	@NotEmpty
	private String customerId;
	
	@JsonProperty(value = "pass_type")
	@Column(name = "pass_type")
	private String passType;
	
	@JsonProperty(value = "size_of_vehicle")
	@Column(name = "size_of_vehicle")
	private String sizeOfVechile;
	
	@OneToOne(cascade=CascadeType.ALL)
	private TimeDuration duration;
	
	@JsonProperty(value="receipt_body")
	@OneToOne(cascade=CascadeType.ALL)
	private ReceiptBody receiptBody;
	
	public Customer() {
		
	}

	public Customer(Long id, String customerId, String passType, String sizeOfVechile, TimeDuration duration) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.passType = passType;
		this.sizeOfVechile = sizeOfVechile;
		this.duration = duration;
	}
	
	public ReceiptBody getReceiptBody() {
		return receiptBody;
	}

	public void setReceiptBody(ReceiptBody receiptBody) {
		this.receiptBody = receiptBody;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public String getSizeOfVechile() {
		return sizeOfVechile;
	}

	public void setSizeOfVechile(String sizeOfVechile) {
		this.sizeOfVechile = sizeOfVechile;
	}

	public TimeDuration getDuration() {
		return duration;
	}

	public void setDuration(TimeDuration duration) {
		this.duration = duration;
	}


	
}

