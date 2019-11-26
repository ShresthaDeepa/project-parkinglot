package com.app.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class TimeInterval {
	
	@JsonProperty(value = "year")
	private String year;
	
	@JsonProperty(value = "month")
	private String month;
	
	public TimeInterval() {
		
	}
	public TimeInterval(String year, String month) {
		super();
		this.year = year;
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	

}
