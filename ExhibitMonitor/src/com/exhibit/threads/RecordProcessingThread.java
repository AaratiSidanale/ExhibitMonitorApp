package com.exhibit.threads;

import java.util.Vector;

import com.exhibit.dto.CustomerRecordDTO;
import com.exhibit.helper.ExhibitMonitorContext;

public class RecordProcessingThread implements Runnable{

	@Override
	public void run() {
		System.out.println("------- | Valid Customer Data | -------");
		saveCustData(ExhibitMonitorContext.getValidCustDataVctr());
		System.out.println("------- | Invalid Customer Data | -------");
		saveCustData(ExhibitMonitorContext.getInValidCustDataVctr());
	}

	private void saveCustData(Vector<CustomerRecordDTO> custDataVctr) {
        for(int i=0; i<custDataVctr.size(); i++){
        	System.out.println(custDataVctr.get(i).toString());
        	custDataVctr.remove(i);
        	System.out.println("Removed element from vector.");
        }
	}

}
