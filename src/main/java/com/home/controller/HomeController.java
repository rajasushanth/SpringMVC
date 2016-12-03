package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/homepage", method=RequestMethod.GET)
	public String home(ModelMap model){
		
		model.addAttribute("msg", "Processed from controller");
		
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexPage(ModelMap model){
		return "index";
	}

}
