package com.exhibit.validator;

import java.text.ParseException;
import java.util.Date;

import com.exhibit.dto.CustomerRecordDTO;
import com.exhibit.helper.UtilityHelper;

public class CustomerDetailsValidator {
	public static boolean isValidCustData(CustomerRecordDTO dto) throws ParseException {
		Date birthDate = UtilityHelper.convertStringToDate(dto.getBirthDate());
		Date deathDate = UtilityHelper.convertStringToDate(dto.getDeathDate());
		
		if(birthDate.after(deathDate)){
			System.out.println("Invalid Record : "+dto.toString());
		}
		return true;
	}

}
