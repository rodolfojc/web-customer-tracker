package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//INJECT CUSTOMER DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//GET CUSTOMER
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//ADD CUSTOMER TO MODEL
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
}
