package com.sapient.demo.inputTransactions;

import java.util.Date;

public class TransactionInput{
	private String clientId;
	private String securityId;
	private String transactionId;
	private String transactionType;
	private Date transactionDate;
	private String marketValue;
	private char priority;
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String transaction) {
		this.marketValue = transaction;
	}

	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransactionInput [clientId=" + clientId + ", securityId=" + securityId + ", transactionId="
				+ transactionId + ", transactionType=" + transactionType + ", transactionDate=" + transactionDate
				+ ", marketValue=" + marketValue + ", priority=" + priority + "]";
	}
}