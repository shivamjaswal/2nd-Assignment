package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Customer;
import com.example.demo.services.CityService;
import com.example.demo.services.CountryService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.StateService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = { "saveCustomer" })
public class SaveController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String savecustomer(ModelMap modelMap) {
		modelMap.put("countries", countryService.findAll());
		return "save";
	}

	@ResponseBody
	@RequestMapping(value = "loadStatesByCountry/{id}", method = RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(stateService.findByCountry(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadCitiesByState/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(cityService.findByState(id));
	}
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String saveData(Customer customer) {
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		customer.setCreated_on(date);
		customerService.save(customer);
		return "saveData";
	}
}