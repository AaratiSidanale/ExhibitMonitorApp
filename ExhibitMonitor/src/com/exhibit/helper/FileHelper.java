package com.exhibit.helper;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

public class FileHelper {
	Map<String, String> tempMap = null;
	
	public static File[] getListOfFiles(String path){
		File[] listOfFiles = null;
		
		File folder = new File(path);
		listOfFiles = folder.listFiles();
		
		return listOfFiles;
	}
	
	public boolean deleteFile(File f){
		//TODO : return f.delete();
		System.out.println(f.getName() + " is deleted.");
		return true;
	}
	
	public boolean isValid(File f){
		tempMap = ExhibitMonitorContext.filePropertyMap;
		if(tempMap != null && tempMap.containsKey(f.getName())){
			return true;
		}else{
			System.out.println(f.getName() + " is invalid file.");
		}
		return false;
	}
	
	public boolean isDuplicate(File f) throws ParseException{
		tempMap = ExhibitMonitorContext.processedFileMap;
		if(tempMap != null && tempMap.containsKey(f.getName())){
			String processeddate = tempMap.get(f.getName());
			//String currentDate = new Date().toString();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			if(processeddate.equals(sdf.format(new Date()))){
				System.out.println(f.getName() + " has been already processed.");
				return true;
			}
		}
		return false;
	}
	
	public boolean isOnTime(File f) throws ParseException{
		tempMap = ExhibitMonitorContext.filePropertyMap;
		
		if(isValid(f)){
			String expectedTime = tempMap.get(f.getName());
			Long receivedTime = f.lastModified();
			
			//TODO: remove date format and check for time
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	        Date expectedTime1 = dateFormat.parse(expectedTime);
	        
	        Calendar expectedCalTime = new GregorianCalendar();
	        Calendar receivedCalTime = new GregorianCalendar();
	        expectedCalTime.setTime(expectedTime1);
	        receivedCalTime.setTimeInMillis(receivedTime);
	        
	        Long timeDiff = expectedCalTime.getTimeInMillis() - receivedCalTime.getTimeInMillis();
	        
	        if(timeDiff > 0){
	        	System.out.println(f.getName() + " is received on time.");
	        	return true;
	        }else{
	        	System.out.println(f.getName() + " is not received on time.");
	        }
		}
		return false;
	}
	
	public void moveProcessedFile(File f)
	{
		File processedFile = new File("D:\\exhibitFiles\\processed\\"+f.getName());
		//TODO: f.renameTo(processedFile);
		System.out.println("Processed file moved to : "+processedFile.getAbsolutePath());
	}
}
