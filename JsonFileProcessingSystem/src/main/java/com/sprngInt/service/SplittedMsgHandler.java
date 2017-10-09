package com.sprngInt.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="splittedMsgHandler")
public class SplittedMsgHandler {
	@ServiceActivator(inputChannel="splittedMsgChannel", autoStartup="true")
	public void processSplittedMsg(Message<?> msg){
		System.out.println("Line : "+msg.getPayload());
	}
}
