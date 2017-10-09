package com.sprngInt.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="transformedMsgHandler")
public class TransformedMsgHandler {
	@ServiceActivator(inputChannel="transformedMsgChannel", autoStartup="true")
	public void printTransformedMsg(Message<?> msg){
		System.out.println(msg.getPayload().toString());
	}
}
