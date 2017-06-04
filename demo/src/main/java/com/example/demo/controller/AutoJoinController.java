package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutoJoinController {
	
    @RequestMapping("/autojoin")
    public String autojoin(Model model) {
    	model.addAttribute("time", "the time");
    	return "autojoin";
    }
    
}
