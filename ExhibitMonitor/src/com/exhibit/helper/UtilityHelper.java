package com.exhibit.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityHelper {
	private static final String dateFormat = "dd-MMM-yyyy";
	
	public static Date convertStringToDate(String strDate) throws ParseException{
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		if(strDate != null && strDate.length() > 0){
			date = sdf.parse(strDate);
		}
		return date;
	}
	
	public static String convertDateToString(Date date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String strDate = sdf.format(date);
		return strDate;
	}
	
}
