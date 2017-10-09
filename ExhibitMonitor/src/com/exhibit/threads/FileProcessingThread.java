package com.exhibit.threads;

import java.io.File;
import java.text.ParseException;

import com.exhibit.helper.ExhibitMonitorContext;
import com.exhibit.helper.FileHelper;

public class FileProcessingThread extends FileHelper implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			File listOfFiles[] = getListOfFiles("D:\\exhibitFiles\\in");
			
			if(listOfFiles.length == 0){
				System.out.println("----Empty Directory----");
				return;
			}else{
				for(File f : listOfFiles){
					System.out.println("------- | "+f.getName()+" | -------");
					try {
						if(!isValid(f) || isDuplicate(f) || !isOnTime(f)){
							deleteFile(f);
						}else{
							System.out.println(f.getName() + " sent for processing as it is \n -> valid, on time and not duplicate.");
							//TODO : processValidFile(f);
							Thread fileParserThread = new Thread(new FileParserThread(f));
							fileParserThread.run();
							ExhibitMonitorContext.addToProcessedFileMap(f.getName());
							moveProcessedFile(f);
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.println("\n");
				}
			}
			notify();
		}
	}
}
