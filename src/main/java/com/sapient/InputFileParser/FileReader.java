package com.sapient.InputFileParser;

import com.sapient.demo.inputTransactions.TransactionInput;

public interface FileReader<T> {
	
	<U extends TransactionInput>U readFile();

}
