package com.sapient.InputFileParser;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sapient.demo.inputTransactions.ReportBean;
import com.sapient.demo.inputTransactions.TransactionInput;

public class CSVFileParser extends FileParser {

	/*
	 * public List<TransactionInput> parseFile() { // TODO Auto-generated method
	 * stub System.out.println("file excel parsed"); return
	 * importFile("datainput.txt");
	 * 
	 * }
	 */

	@Override
	public <T extends TransactionInput> List<TransactionInput> parseFile(String fileName) {
		// TODO Auto-generated method stub

		List<TransactionInput> transactionInputList = importFile(fileName);
		generateReport(transactionInputList);
		return transactionInputList;

	}

	private List<TransactionInput> importFile(String fileName) {
		String splitBy = ",";
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		// first map to put key as client id and value list of all transaction for as client
		Map<String ,List<TransactionInput>> transactionInputMap = new LinkedHashMap<>();
		
		//	System.out.println(transactionInputList);
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] transaction = line.split(splitBy);
				//System.out.println(transaction.toString());
				try {
					List<TransactionInput> transactionInputList = new ArrayList<>();
					TransactionInput transactionInput = new TransactionInput();
					transactionInput.setTransactionId(transaction[0].trim());
					transactionInput.setClientId(transaction[1].trim());
					transactionInput.setSecurityId(transaction[2].trim());
					transactionInput.setTransactionType(transaction[3].trim());

					transactionInput.setTransactionDate(dateFormat.parse(transaction[4].trim()));

					transactionInput.setMarketValue(transaction[5].trim());
					transactionInput.setPriority(transaction[6].trim().charAt(0));
					
					transactionInputList.add(transactionInput);
					
					if(!transactionInputMap.isEmpty() && transactionInputMap.containsKey(transactionInput.getClientId())){
						transactionInputMap.get(transactionInput.getClientId()).add(transactionInput);
					}
					else{
						transactionInputMap.put(transactionInput.getClientId(), transactionInputList);
						
					}
					
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			scanner.close();
		//	System.out.println("transactionInputList-----------------------------------------"+transactionInputMap);
			generateReportV1(transactionInputMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ArrayList<TransactionInput>();

	}
	
	private void generateReportV1(Map<String, List<TransactionInput>> transactionInputMap){
		Map<ReportBean, Integer> repportMap = new HashMap<>();
		for (Map.Entry<String, List<TransactionInput>> entry : transactionInputMap.entrySet())
			
		{
			//String clientId = entry.getKey();
			List<TransactionInput> list = entry.getValue();
			repportMap = calculatePrice(list,repportMap);
		}
		
		 System.out.println("================="+repportMap.toString());
		
	}
	
	private Map<ReportBean, Integer> calculatePrice(List<TransactionInput> list,Map<ReportBean, Integer> repportMap){
		
		 for(TransactionInput dto :list){
			 
			   ReportBean reportBean = new ReportBean();
			   reportBean.setTransactionId(dto.getTransactionId());
			   reportBean.setClientId(dto.getClientId());
			   reportBean.setSecurityId(dto.getSecurityId());
			   reportBean.setTransactionType(dto.getTransactionType());
			   reportBean.setPriority(dto.getPriority()+"");
			   reportBean.setTransactionDate(dto.getTransactionDate());
			   reportBean = addProcessingFee(repportMap,dto,reportBean);
			   calculateNormalPrice(reportBean);
			   repportMap.put(reportBean, reportBean.getProcessingFee());
		 }
		 
		 //System.out.println("================="+repportMap.toString());
		return repportMap;
	}
	
	private ReportBean  addProcessingFee(Map<ReportBean, Integer> repportMap,TransactionInput transactionInput,ReportBean reportBean){
		if(repportMap.isEmpty()){
			reportBean.setProcessingFee(10);
		}
		else{
			for (ReportBean entry : repportMap.keySet()){
				if(entry.getTransactionType().equalsIgnoreCase(transactionInput.getTransactionType()) 
						&& entry.getTransactionDate().equals(transactionInput.getTransactionDate())){
					reportBean.setProcessingFee(0);
				}
				else{
					reportBean.setProcessingFee(10);
				}
			}
		}
		return reportBean;
	}
	
	private ReportBean calculateNormalPrice(ReportBean reportBean){
		
		if(reportBean.getPriority().equalsIgnoreCase("y")){
			reportBean.setProcessingFee(reportBean.getProcessingFee()+500);
		}
		else{
			if(reportBean.getTransactionType().equalsIgnoreCase("BUY") || reportBean.getTransactionType().equalsIgnoreCase("DEPOSIT")){
				reportBean.setProcessingFee(reportBean.getProcessingFee()+50);
			}
			else if(reportBean.getTransactionType().equalsIgnoreCase("WITHDRAW") || reportBean.getTransactionType().equalsIgnoreCase("SELL")){
				reportBean.setProcessingFee(reportBean.getProcessingFee()+100);
			}
		}
		 
		return reportBean;
	}

	// generate report

	void generateReport(List<TransactionInput> transactionInputList) {
		// check transaction type---
	//	System.out.println("transactionInputList  :"+transactionInputList.toString());
		for (int i = 0; i < transactionInputList.size(); i++) {
			for (int j = i+1; j < transactionInputList.size(); j++) {
				if (transactionInputList.get(j).getClientId()==transactionInputList.get(i).getClientId() &&
						transactionInputList.get(j).getSecurityId() == transactionInputList.get(i).getSecurityId()) {
					///System.out.println("-----------------------++++++++++++++++++++++++++++++++++++++-----------------------");
				//	System.out.println("equeal case j :" +transactionInputList.get(j).toString());
				//	System.out.println("----------------------------------------------");
					//System.out.println("equeal case with i  :"  +transactionInputList.get(i).toString());


				}else{
					//	System.out.println("--------------------------");
				}
			}

		}

	}}
