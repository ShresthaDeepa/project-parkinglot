package com.app.serviceimpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.constant.PriceTag;
import com.app.model.Customer;
import com.app.model.ReceiptBody;
import com.app.model.TimeInterval;
import com.app.repository.Receiptrepository;
import com.app.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private Receiptrepository receiptRepo;

	public ReceiptBody createReceipt(Customer customer) {
		LocalDateTime entryTime = customer.getDuration().getEntryTime();
		LocalDateTime exitTime = customer.getDuration().getExitTime();
		Long duration = calculateTotalDuration(entryTime, exitTime);
		String timeDuration = String.format("%d", duration);

		String passType = customer.getPassType();
		String sizeOfVehicle = customer.getSizeOfVechile();
		Double hourlyPrice = calculateHourlyPrice(duration, sizeOfVehicle, passType);
		return new ReceiptBody(timeDuration, hourlyPrice);
	}

	public Long calculateTotalDuration(LocalDateTime entryTime, LocalDateTime exitTime) {
		return LocalDateTime.from(entryTime).until(exitTime, ChronoUnit.HOURS);
	}

	public Double calculateHourlyPrice(Long duration, String sizeOfVehicle, String passType) {
		
		System.out.println(PriceTag.priceMap.get(sizeOfVehicle.toUpperCase() + "_" + passType.toUpperCase()));
		return Objects.nonNull(duration)
				? PriceTag.priceMap.get(sizeOfVehicle.toUpperCase() + "_" + passType.toUpperCase()) * duration
				: PriceTag.priceMap.get(sizeOfVehicle.toUpperCase() + "_" + passType.toUpperCase());
	}	
	

	
	public ReceiptBody saveTimeInterval(TimeInterval timeInterval) {
		String yearMonth = timeInterval.getYear() + "-" + timeInterval.getMonth();		
		return receiptRepo.findByTimeInterval(yearMonth);
	}

}
