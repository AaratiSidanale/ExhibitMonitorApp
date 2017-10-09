package com.exhibit.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.exhibit.helper.ExhibitMonitorContext;
import com.exhibit.threads.FileProcessingThread;
import com.exhibit.threads.RecordProcessingThread;

public class ExhibitMonitorApplication {
	
	public static void main(String[] args) {
		ExhibitMonitorContext monitorContext = null;
		
		try {
			monitorContext = ExhibitMonitorContext.loadExhibitMonitorContext();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println("Exception occurred while loading application context.\n"+e.getMessage());
		}
	
		Thread processingThread = new Thread(new FileProcessingThread());
		processingThread.start();
		
		synchronized (processingThread) {
			Thread recordProcessingThread = new Thread(new RecordProcessingThread());
			try {
				recordProcessingThread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
