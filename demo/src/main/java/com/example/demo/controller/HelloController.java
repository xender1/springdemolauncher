package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.WMIObject;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/helloworld")
	public String helloworld() {
		int c = WMIObject.getInstance().getWMICount();
		return  Integer.toString(c);
		//return "Hello world";
	}
}
