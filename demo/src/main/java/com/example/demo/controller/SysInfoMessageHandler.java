package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import com.example.demo.WMIObject;
import com.example.demo.model.AutoJoinMessage;
import com.example.demo.model.SimpleStompMessage;

public class SysInfoMessageHandler {
	
	@MessageMapping("/sysinfomessage")
	@SendTo("/topic/sysinfo")
	public SimpleStompMessage autojoinmessage(AutoJoinMessage message) throws Exception {
		String hello = WMIObject.getInstance().simpleQuery();
		return new SimpleStompMessage(message.getMessage());
	}

}
