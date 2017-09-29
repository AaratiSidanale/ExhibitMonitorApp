package com.exhibit.helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ExhibitMonitorContext {
	private XMLParser xmlParser = null;
	static ExhibitMonitorContext monitorContext = null;
	
	public static Map<String, String> filePropertyMap = null;
	public static Map<String, String> processedFileMap = null;
	
	private ExhibitMonitorContext() throws SAXException, IOException, ParserConfigurationException{
		xmlParser = XMLParser.getInstance();
		filePropertyMap = xmlParser.getFilePropertyMap();
		
		//temporary added for testing purpose
		processedFileMap = new HashMap<String, String>();
		processedFileMap.put("b.csv", "29-09-2017");
	}
	
	public static ExhibitMonitorContext loadExhibitMonitorContext() throws SAXException, IOException, ParserConfigurationException{
		if(monitorContext == null){
			monitorContext = new ExhibitMonitorContext();
		}
		return monitorContext;
	}

}
