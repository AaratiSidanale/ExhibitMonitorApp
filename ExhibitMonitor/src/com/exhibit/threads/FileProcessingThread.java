package com.exhibit.threads;

import java.io.File;
import java.text.ParseException;

import com.exhibit.helper.FileHelper;

public class FileProcessingThread extends FileHelper implements Runnable {

	@Override
	public void run() {
			File listOfFiles[] = getListOfFiles("D:\\exhibitFiles\\in");
			
			if(listOfFiles.length == 0){
				System.out.println("----Empty Directory----");
				return;
			}
			
			for(File f : listOfFiles){
				System.out.println("------- | "+f.getName()+" | -------");
				try {
					if(!isValid(f) || isDuplicate(f) || !isOnTime(f)){
						deleteFile(f);
					}else{
						System.out.println(f.getName() + " sent for processing as it is \n -> valid, on time and not duplicate.");
						//TODO : processValidFile(f);
						moveProcessedFile(f);
					}
					/*if(isValid(f)){
						if(!isDuplicate(f)){
							if(isOnTime(f)){
								
							}
						}
					}*/
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\n");
			}
	}
}
