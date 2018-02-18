package com.sapient.demo.inputTransactions;

public interface Identifiable<T extends Lookup> {
	  String constantName();

	  long id();

	  T instance();
	}