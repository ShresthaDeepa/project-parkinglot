package com.app.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.model.ReceiptBody;
import com.app.repository.Receiptrepository;

@Repository
public class ReceiptRepositoryImpl implements Receiptrepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public ReceiptBody findByTimeInterval(String yearMonth) {
		ReceiptBody receiptBody = (ReceiptBody) manager.createNamedQuery("findByTimeInterval", ReceiptBody.class).setParameter(1, yearMonth).getResultList();
		
		return receiptBody;
	}
	
	

}
