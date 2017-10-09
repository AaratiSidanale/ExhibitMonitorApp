package com.exhibit.helper;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.exhibit.dto.CustomerRecordDTO;

public class ExhibitMonitorContext {
	private XMLParser xmlParser = null;
	static ExhibitMonitorContext monitorContext = null;
	
	private static Map<String, String> filePropertyMap = null;
	private static Map<String, String> processedFileMap = null;
	
	private static Vector<CustomerRecordDTO> validCustDataVctr = null;
	private static Vector<CustomerRecordDTO> inValidCustDataVctr = null;	
	
	private ExhibitMonitorContext() throws SAXException, IOException, ParserConfigurationException{
		xmlParser = XMLParser.getInstance();
		filePropertyMap = xmlParser.getFilePropertyMap();
		
		//TODO : remove after testing
		processedFileMap = new HashMap<String, String>();
		processedFileMap.put("b.csv", "03-OCT-2017");
	}
	
	public static ExhibitMonitorContext loadExhibitMonitorContext() throws SAXException, IOException, ParserConfigurationException{
		if(monitorContext == null){
			monitorContext = new ExhibitMonitorContext();
		}
		return monitorContext;
	}
	
	public static void addToProcessedFileMap(String fileName) throws ParseException{
		if(processedFileMap == null){
			processedFileMap = new HashMap<String, String>();
		}
		String currentDate = UtilityHelper.convertDateToString(new Date());
		processedFileMap.put(fileName, currentDate);
	}
	
	public static Map<String, String> getFilePropertyMap() {
		return filePropertyMap;
	}

	public static Map<String, String> getProcessedFileMap() {
		return processedFileMap;
	}

	public static Vector<CustomerRecordDTO> getValidCustDataVctr() {
		return validCustDataVctr;
	}

	public static Vector<CustomerRecordDTO> getInValidCustDataVctr() {
		return inValidCustDataVctr;
	}
}
