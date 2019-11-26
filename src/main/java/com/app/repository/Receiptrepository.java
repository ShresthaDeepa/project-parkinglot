package com.app.repository;





import com.app.model.ReceiptBody;
import com.app.model.TimeInterval;

public interface Receiptrepository {
	
	public ReceiptBody findByTimeInterval(String yearMonth);
	

}
