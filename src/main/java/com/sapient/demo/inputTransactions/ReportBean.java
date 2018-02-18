package com.sapient.demo.inputTransactions;

import java.util.Date;

public class ReportBean {
	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private String priority;
	private Integer processingFee;
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Integer getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(Integer processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportBean other = (ReportBean) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReportBean [transactionId=" + transactionId + ", clientId=" + clientId + ", securityId=" + securityId
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + ", priority="
				+ priority + ", processingFee=" + processingFee + "]";
	}
	
	
	
	

}
