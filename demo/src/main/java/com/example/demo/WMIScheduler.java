package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.example.demo.model.SimpleStompMessage;


@EnableScheduling
@Controller
public class WMIScheduler {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	public WMIScheduler() {
		
	}
	
	@Scheduled(fixedDelay=5000)
	public void simpleTask() {
		WMIObject.getInstance().increaseCount();
		
		//SimpleStompMessage message = new SimpleStompMessage(Integer.toString(WMIObject.getInstance().getWMICount()));
		SimpleStompMessage message = new SimpleStompMessage("pre");
		try {
			message = new SimpleStompMessage(WMIObject.getInstance().setCpuTemp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.template.convertAndSend("/topic/autojoin", message);	
		//System.out.println("simpleTask: " + WMIObject.getInstance().getWMICount());
	}
}
