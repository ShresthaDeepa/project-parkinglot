package com.app.service;

import com.app.model.ReceiptBody;
import com.app.model.TimeInterval;

public interface ReceiptService{

	public ReceiptBody saveTimeInterval(TimeInterval timeInterval);
}
