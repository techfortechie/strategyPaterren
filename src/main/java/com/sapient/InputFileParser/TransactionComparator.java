package com.sapient.InputFileParser;

import java.util.Comparator;

import com.sapient.demo.inputTransactions.TransactionInput;

public class TransactionComparator implements Comparator<TransactionInput>{
	@Override
	public int compare(TransactionInput t1, TransactionInput t2) {
		int result = -1;

		if(t1.getTransactionDate().equals(t2.getTransactionDate())) {
			if(t1.getClientId().equals(t2.getClientId()) && t1.getSecurityId().equals(t2.getSecurityId())) {
				if(t1.getTransactionType().equals("BUY") && t2.getTransactionType().equals("SELL") || t1.getTransactionType().equals("SELL") && t2.getTransactionType().equals("BUY")) {
					result = 0;
				}
			}
		} else if (t1.getTransactionDate().before(t2.getTransactionDate())) {
			result = 1;
		}

		return result;
	}  

}