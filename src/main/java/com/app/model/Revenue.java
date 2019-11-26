package com.app.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Revenue {
	
	@JsonProperty(value = "year_month")
	private String yearMonth;
	
	@JsonProperty(value = "total_revenue")
	private Double totalRevenue;
	public Revenue() {
		
	}
	public Revenue(String yearMonth, Double totalRevenue) {
		super();
		this.yearMonth = yearMonth;
		this.totalRevenue = totalRevenue;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
}
