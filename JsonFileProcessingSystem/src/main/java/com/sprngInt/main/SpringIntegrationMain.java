package com.sprngInt.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringIntegrationMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----");
	}

}
