package com.sapient.demo;

import com.sapient.demo.inputTransactions.ExternalInputTransaction;
import com.sapient.demo.inputTransactions.TransactionInput;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExternalInputTransaction externalInputTransaction = new ExternalInputTransaction(3);
		
		System.out.println(ExternalInputTransaction.TransactionType.BUY.id());
		System.out.println(ExternalInputTransaction.SecurityType.HINDALCO.id());
		System.out.println(ExternalInputTransaction.ClientType.AP.id());
		System.out.println("externalInputTransaction --"  +externalInputTransaction);
	//	externalInputTransaction
		
//		TransactionInput transactionInput = new TransactionInput(5);
//		transactionInput.setClientId(2);
//		transactionInput.setSecurityId(2);
//		transactionInput.setTransactionId(1);
//		if(ExternalInputTransaction.TransactionType.BUY.id()==transactionInput.getTransactionId()){
//			System.out.println(" tested now if");
//		}
		
	}

}
