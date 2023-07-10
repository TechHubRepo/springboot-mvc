package com.techhub.customer.adaptor;

import com.techhub.customer.dto.CustomerDTO;
import com.techhub.customer.model.Customer;

/**
 * The ContactAdaptor
 * 
 * @author ramniwash
 *
 */
public final class CustomerAdaptor {

	private CustomerAdaptor() {
	}

	public static final Customer toContact(CustomerDTO contactDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(contactDTO.getCustomerId());
		customer.setCustomerName(contactDTO.getCustomerName());
		customer.setMobileNumber(contactDTO.getMobileNumber());
		customer.setEmailId(contactDTO.getEmailId());
		customer.setDescription(contactDTO.getDescription());
		customer.setPrice(contactDTO.getPrice());
		customer.setGender(contactDTO.getGender());
		customer.setDateOfBirth(contactDTO.getDateOfBirth());
		StringBuilder servicesSB = new StringBuilder();
		for (String service : contactDTO.getServicesTaken()) {
			servicesSB.append(service).append(",");
		}
		servicesSB.deleteCharAt(servicesSB.length() - 1);
		customer.setServicesTaken(servicesSB.toString());
		return customer;
	}

	public static final CustomerDTO toContactDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setMobileNumber(customer.getMobileNumber());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setDescription(customer.getDescription());
		customerDTO.setPrice(customer.getPrice());
		customerDTO.setGender(customer.getGender());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setCreatedOn(customer.getCreatedOn());
		customerDTO.setUpdatedOn(customer.getUpdatedOn());
		String[] services = customer.getServicesTaken().split(",");
		customerDTO.setServicesTaken(services);
		return customerDTO;
	}
}
