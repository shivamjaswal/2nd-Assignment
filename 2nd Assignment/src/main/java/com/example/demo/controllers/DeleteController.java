package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

@Controller
@RequestMapping(path = "/deleteCustomer")
public class DeleteController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "delete";	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String searchData(Customer customerEntity,Model model) {
	customerService.delete(customerEntity);

		return "deleteData";	
	}
}
