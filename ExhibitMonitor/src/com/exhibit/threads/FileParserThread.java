package com.exhibit.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.exhibit.dto.CustomerRecordDTO;
import com.exhibit.helper.UtilityHelper;
import com.exhibit.validator.CustomerDetailsValidator;

public class FileParserThread implements Runnable{
	private File file;
	private static final String COMMA_DELIMITER = ",";
	
	public FileParserThread(File f){
		super();
		this.file = f;
	}
	
	@Override
	public void run() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			
			String line = "";
			while((line = br.readLine()) != null){
				String[] custDetails = line.split(COMMA_DELIMITER);
				
				/*CustomerRecordDTO(srNo, firstNm, lastNm, birthDate, deathDate, loanAmnt)*/
				CustomerRecordDTO custDto = new CustomerRecordDTO(
						Integer.parseInt(custDetails[0]), custDetails[1], custDetails[2], 
						custDetails[3], custDetails[4], Integer.parseInt(custDetails[5]));
				boolean isValidData = CustomerDetailsValidator.isValidCustData(custDto);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
