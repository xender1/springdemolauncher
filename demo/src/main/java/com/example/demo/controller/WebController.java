package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

   @RequestMapping("/sysinfo")
    public String sysinfo(Model model) {
    	return "sysinfo";
    }
   
   @RequestMapping("/autojoin")
   public String autojoin(Model model) {
   	model.addAttribute("time", "the time");
   	return "autojoin";
   }
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
}