package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//does the wmi queries and returns
public class WMIObject {
	
	private static final String fullQuery = "wmic /NAMESPACE:\\\\root\\OpenHardwareMonitor PATH Sensor WHERE " + 
			"\"Identifier='/intelcpu/0/temperature/4' or Identifier='/intelcpu/0/load/0'" +
			"or Identifier='/nvidiagpu/0/temperature/0' or Identifier='/nvidiagpu/0/load/0'\" GET Value";

	
	
	private static volatile WMIObject wmiObj = new WMIObject();
	private static volatile int simpleWMICount = 0;
	
	private WMIObject() {
		
	}
	
	public static WMIObject getInstance() {
		return wmiObj;
	}
	
	public String simpleQuery() {
		return "Hello!!!";
	}
	
	public void testDelay() {
		System.out.println("test delay");
	}
	
	public void increaseCount() {
		simpleWMICount++;
	}
	
	public int getWMICount() {
		return simpleWMICount;
	}
	
	public String setCpuTemp() throws IOException, InterruptedException {
		String retString = "";
		Process proc = Runtime.getRuntime().exec(fullQuery); //rt.exec(commands);
		
		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new 
		     InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			if (!s.isEmpty()) {
				if (!s.trim().equals("Value")) {
					//System.out.println(s);
					Integer val = Math.round(Float.parseFloat(s.trim()));
					retString = retString + " " + val;
				}
			}
		}
		proc.waitFor();

		// read any errors from the attempted command

		while ((s = stdError.readLine()) != null) {
			System.out.println("Errors (if any):\n");
		    System.out.println(s);
		}
		proc.waitFor();
		
		stdInput.close();
		stdError.close();
		
		return retString.trim();
	}
}
