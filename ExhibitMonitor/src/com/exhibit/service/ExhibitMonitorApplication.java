package com.exhibit.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.exhibit.helper.ExhibitMonitorContext;
import com.exhibit.threads.FileProcessingThread;

public class ExhibitMonitorApplication {
	
	public static void main(String[] args) {
		ExhibitMonitorContext monitorContext = null;
		
		try {
			monitorContext = ExhibitMonitorContext.loadExhibitMonitorContext();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println("Exception occurred while loading application context.\n"+e.getMessage());
		}
	
		Thread processingThread = new Thread(new FileProcessingThread());
		processingThread.run();
	}

}
