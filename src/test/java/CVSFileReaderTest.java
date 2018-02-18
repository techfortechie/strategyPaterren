import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.sapient.demo.inputTransactions.TransactionInput;
import com.sapient.demo.reportBuilder.BaseReportBuilder;
import com.sapient.demo.reportBuilder.ReportBuilder;

public class CVSFileReaderTest {
	String splitBy = ",";  
	
	String file  ="datainput.txt";
	String fileexl  ="sapientworksheet.xlsx";
	String fileevl  ="sampleData.txt";

	@Test
public void	readCVSfile(){
		// String result = importFile("datainput.txt");
	/*	IFileParser<TransactionInput> parser = new CSVFileParser();
		parser.parseFile(file);*/
		
		ReportBuilder rb = new BaseReportBuilder(fileevl);
		
		rb.generateReport();
}
	  private String importFile(String fileName){

		  StringBuilder result = new StringBuilder("");

			//Get file from resources folder
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			// System.out.println("file----"+file);
			 
			 List<TransactionInput> transactionInputList = new ArrayList();
			 System.out.println(transactionInputList);
			try (Scanner scanner = new Scanner(file)) {

				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					//System.out.println("line----"+line);
					 String[] transaction = line.split(splitBy);  
				//	result.append(line).append("\n");
					 System.out.println(transaction.toString());
					 TransactionInput transactionInput = new TransactionInput();
					 transactionInput.setTransactionId(transaction[0]);
					 transactionInput.setClientId(transaction[1]);
					 transactionInput.setSecurityId(transaction[2]);
					 transactionInput.setTransactionType(transaction[3]);
					 transactionInput.setTransactionDate(new Date(transaction[4]));
					 transactionInput.setMarketValue( transaction[5]);
					 transactionInput.setPriority(transaction[6].charAt(0));
					 transactionInputList.add(transactionInput);
				}

				scanner.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return result.toString();

		  }


	  }

