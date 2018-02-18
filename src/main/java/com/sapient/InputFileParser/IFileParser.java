package com.sapient.InputFileParser;

import java.util.List;

import com.sapient.demo.inputTransactions.TransactionInput;


public interface IFileParser<T> {
	<T extends TransactionInput> List<TransactionInput> parseFile(String fileName);
	
	
	// <T extends TransactionInput> void getFileType();

}
