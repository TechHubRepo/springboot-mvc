package com.techhub.customer.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techhub.customer.dto.CustomerDTO;
import com.techhub.customer.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

/**
 * The Controller for Contact
 * 
 * @author ramniwash
 */
@Controller
public class CustomerController {

	/** The Constant LOGGER */
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);

	/** The Constant SUCCESS */
	private static final String SUCCESS = "success";

	/** The Constant ADD_CUSTOMER */
	private static final String ADD_CUSTOMER = "add-customer";
	
	/** The Constant UPDATE_CUSTOMER */
	private static final String UPDATE_CUSTOMER = "update-customer";

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/")
	public ModelAndView index() {
		LOGGER.info(":::: SHOWING CUSTOMER DASHBOARD :::::");
		return new ModelAndView("index");
	}

	@GetMapping(value = "/add-customer")
	public ModelAndView addCustomer(Model model) {
		LOGGER.info(":::: ENTERING INTO ADD NEW CUSTOMER :::::");
		model.addAttribute("customerDTO", new CustomerDTO());
		return new ModelAndView(ADD_CUSTOMER);
	}

	@PostMapping(value = "/add-customer")
	public ModelAndView addCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult errors, Model model) {
		LOGGER.info(":::: ADDING NEW CUSTOMER :::::");
		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			modelAndView.setViewName(ADD_CUSTOMER);
			model.addAttribute("contactDTO", customerDTO);
		} else {
			customerDTO = this.customerService.saveCustomer(customerDTO);
			modelAndView.addObject("msg","New Customer added successfully : Customer ID = " + customerDTO.getCustomerId());
			modelAndView.setViewName(SUCCESS);
		}
		return modelAndView;
	}

	@GetMapping(value = "/view-customer")
	public ModelAndView viewCustomer(Model model, @PathParam("idx") int idx, @PathParam("lmt") int lmt) {
		LOGGER.info(":::: SHOWING VIEW CUSTOMER :::::");
		List<CustomerDTO> customerDTOs = this.customerService.getAllCustomer(idx, lmt);
		model.addAttribute("customerDTOs", customerDTOs);
		return new ModelAndView("view-customer");
	}

	@GetMapping(value = "/update-customer/{cid}")
	public ModelAndView updateCustomer(@PathVariable(name = "cid") Long cid, Model model) {
		LOGGER.info(":::: SHOWING UPDATE CUSTOMER :::::");
		CustomerDTO customerDTO = this.customerService.getCustomer(cid);
		model.addAttribute("customerDTO", customerDTO);
		return new ModelAndView(UPDATE_CUSTOMER);
	}

	@PostMapping(value = "/update-customer")
	public ModelAndView updateCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult errors,
			Model model) {
		LOGGER.info(":::: UPDATING THE CUSTOMER :::::");
		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			modelAndView.setViewName(UPDATE_CUSTOMER);
			model.addAttribute("contactDTO", customerDTO);
		} else {
			customerDTO = this.customerService.updateCustomer(customerDTO);
			modelAndView.addObject("msg","Customer Updated successfully : Customer ID = " + customerDTO.getCustomerId());
			modelAndView.setViewName(SUCCESS);
		}
		return modelAndView;
	}

	@GetMapping(value = "/delete-customer")
	public ModelAndView deleteCustomer() {
		LOGGER.info(":::: SHOWING DELETE CUSTOMER :::::");
		return new ModelAndView("delete-customer");
	}

	@PostMapping(value = "/delete-customer")
	public ModelAndView deleteCustomer(@RequestParam(name = "cid") Long cid) {
		LOGGER.info(":::: DELETING THE CUSTOMER :::::");
		this.customerService.deleteCustomerById(cid);
		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		modelAndView.addObject("msg", "Customer deleted successfully : Customer ID = " + cid);
		return modelAndView;
	}
}