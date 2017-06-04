package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.demo.model.SimpleStompMessage;
import com.example.demo.model.AutoJoinMessage;

@Controller
public class AutoJoinMessageHandler {

	@MessageMapping("/autojoinmessage")
	@SendTo("/topic/autojoin")
	public SimpleStompMessage autojoinmessage(AutoJoinMessage message) throws Exception {
		return new SimpleStompMessage("Hello, " + message.getMessage() + "!");
	}
	
}
