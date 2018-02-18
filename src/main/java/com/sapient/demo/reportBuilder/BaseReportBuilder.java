package com.sapient.demo.reportBuilder;

import java.util.Collections;
import java.util.List;

import com.sapient.InputFileParser.CSVFileParser;
import com.sapient.InputFileParser.IFileParser;
import com.sapient.InputFileParser.TransactionComparator;
import com.sapient.demo.inputTransactions.TransactionInput;
import com.sapient.demo.parser.FileType;

public class BaseReportBuilder implements ReportBuilder {
	String fileName = "";

	public BaseReportBuilder(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<TransactionInput> getfilefromlocationlocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateReport() {
		FileType fileTypetoBeParse = getFileType(fileName);
		if (fileTypetoBeParse.getId() ==3) {
			IFileParser<TransactionInput> parser = new CSVFileParser();
			List<TransactionInput> parsedTransactionInput= 	parser.parseFile(fileName);
			
			Collections.sort(parsedTransactionInput, new TransactionComparator());
			
			for (TransactionInput transactionInput : parsedTransactionInput) {
			//	System.out.println(transactionInput);
			}
		}else if(fileTypetoBeParse.getId() ==2){
			
		}

	}

	@Override
	public FileType getFileType(String fileTypeStatus) {
		/*if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			System.out.println("file type  --: " + fileName.substring(fileName.lastIndexOf(".") + 1));*/
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);

		if (fileType.equals(FileType.Name.txt.constantName())) {
			return FileType.Name.txt.instance();
		} else if (fileType.equals(FileType.Name.xlsx.constantName())) {
			return FileType.Name.xlsx.instance();
		} else {
			return null;
		}

	}
}
