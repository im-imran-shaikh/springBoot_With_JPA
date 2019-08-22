package com.springBoot.CRUDWithJpaAndH2.controller;

import java.util.Iterator;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBoot.CRUDWithJpaAndH2.dao.SmartPhoneRepository;
import com.springBoot.CRUDWithJpaAndH2.dto.SmartPhone;

@Controller
public class PageController
{
	@Autowired
	SmartPhoneRepository smartPhoneRepo;

	@RequestMapping(
	{ "/", "/home" })
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Welcome to spring boot application with JPA and H2 database");
		return mv;
	}

	@RequestMapping("/smartPhones")
	public ModelAndView smartPhones()
	{
		ModelAndView mv = new ModelAndView("GetAllSmartPhone");

		Iterable<SmartPhone> smartPhone = smartPhoneRepo.findAll();
		Iterator<SmartPhone> iterator = smartPhone.iterator();
		while (iterator.hasNext())
		{
			SmartPhone smartPhoneObj = iterator.next();
			System.out.println(smartPhoneObj.getId() + " " + smartPhoneObj.getBrand() + " " + smartPhoneObj.getModel()
					+ " " + smartPhoneObj.getPrice());
			mv.addObject("id", smartPhoneObj.getId());
			mv.addObject("brand", smartPhoneObj.getBrand());
			mv.addObject("model", smartPhoneObj.getModel());
			mv.addObject("price", smartPhoneObj.getPrice());
		}

		return mv;
	}

	@RequestMapping("/addSmartPhone")
	public ModelAndView addSmartPhone(SmartPhone smartPhone)
	{
		if (smartPhone.getBrand() != null && smartPhone.getModel() != null && smartPhone.getPrice() != 0)
			smartPhoneRepo.save(smartPhone);
		ModelAndView mv = new ModelAndView("AddSmartPhonePage");
		return mv;
	}

	@RequestMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id)
	{
		smartPhoneRepo.deleteById(id);
		return String.valueOf(id) + " deleted";
	}

	@RequestMapping("/update")
	public String updatePrice(int price, int id)
	{
		smartPhoneRepo.updatePrice(price, id);
		System.out.println(String.valueOf(id) + " is updated");
		return String.valueOf(id) + " is updated";
	}

	@RequestMapping("/updatePrice")
	public ModelAndView updatePrice()
	{
		ModelAndView mv = new ModelAndView("updatePrice");
		return mv;
	}

	@RequestMapping("/findByPrice/{price}")
	public void findByPrice(@PathVariable(value = "price") int price)
	{
		System.out.println("Under findByprice and price is " + price);
		List<SmartPhone> sortedByPrice = smartPhoneRepo.findByPrice(price);
		for (SmartPhone byPrice : sortedByPrice)
		{
			System.out.println(
					byPrice.getId() + " " + byPrice.getBrand() + " " + byPrice.getModel() + " " + byPrice.getPrice());
		}

	}
}
