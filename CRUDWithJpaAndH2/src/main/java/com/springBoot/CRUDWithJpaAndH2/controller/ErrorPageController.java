package com.springBoot.CRUDWithJpaAndH2.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController implements ErrorController
{

	@RequestMapping("/error")
	public ModelAndView error()
	{
		ModelAndView mv = new ModelAndView("Error");
		mv.addObject("error", "Oh! Caught you, please dont play with URL");
		return mv;
	}
	
	@Override
	public String getErrorPath()
	{
		// TODO Auto-generated method stub
		return "error";
	}

}
