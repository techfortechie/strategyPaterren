package com.sapient.demo.inputTransactions;

public class ExternalInputTransaction extends Lookup {

	public ExternalInputTransaction(long id) {
		super(id);
	}

	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public enum TransactionType implements Identifiable<ExternalInputTransaction> {
		BUY(1), SELL(2), DEPOSIT(3), WITHDRAW(4);

		private long identifier;

		TransactionType(int id) {
			identifier = id;
		}

		public String constantName() {
			// TODO Auto-generated method stub
			return this.name();
		}

		public long id() {
			// TODO Auto-generated method stub
			return this.identifier;
		}

		public ExternalInputTransaction instance() {
			// TODO Auto-generated method stub
			return new ExternalInputTransaction(this.identifier);
		}

	}

	public enum SecurityType implements Identifiable<ExternalInputTransaction> {
		ICICI(1), REL(2), HINDALCO(3), RELIND(4);

		private long identifier;

		SecurityType(int id) {
			identifier = id;
		}

		public String constantName() {
			// TODO Auto-generated method stub
			return this.name();
		}

		public long id() {
			// TODO Auto-generated method stub
			return this.identifier;
		}

		public ExternalInputTransaction instance() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public enum ClientType implements Identifiable<ExternalInputTransaction> {
		GS(1), AP(2), AS(3), HJ(4);
		private long identifier;

		ClientType(int id) {
			identifier = id;
		}

		public String constantName() {
			// TODO Auto-generated method stub
			return null;
		}

		public long id() {
			// TODO Auto-generated method stub
			return this.identifier;
		}

		public ExternalInputTransaction instance() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
