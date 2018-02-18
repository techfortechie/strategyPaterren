package com.sapient.demo.reportBuilder;

import java.util.List;

import com.sapient.demo.inputTransactions.TransactionInput;
import com.sapient.demo.parser.FileType;

public interface ReportBuilder {
	
	 List<TransactionInput>	 getfilefromlocationlocation();
	
	void generateReport();
	

	FileType getFileType(String fileTypeStatus);
	 
	 
	
	 // create instance of object based on file types . 
 

}
