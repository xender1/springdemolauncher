package com.example.demo;

//does the wmi queries and returns
public class WMIObject {
	private static volatile WMIObject wmiObj = new WMIObject();
	
	private WMIObject() {
		
	}
	
	public static WMIObject getInstance() {
		return wmiObj;
	}
	
	public String simpleQuery() {
		return "Hello!!!";
	}
}
