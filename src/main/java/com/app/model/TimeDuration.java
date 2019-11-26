package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@Entity
@Table(name= "duration_info")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class TimeDuration implements ParkingLotDomain{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9062188305824496774L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonIgnore
	private Long id;
	
	@JsonProperty(value = "entry_time")
	@Column(name = "entry_time")
	private LocalDateTime entryTime ;
	
	@JsonProperty(value = "exit_time")
	@Column(name = "exit_time")
	private LocalDateTime exitTime;
	
	public TimeDuration()
	{
		
	}

	public TimeDuration(Long id, LocalDateTime entryTime, LocalDateTime exitTime) {
		super();
		this.id = id;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	
	
	

	
	

}
