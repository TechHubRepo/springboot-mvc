package com.techhub.customer.service;

import java.util.List;

import com.techhub.customer.dto.CustomerDTO;

/**
 * The Contact Service interface
 * 
 * @author ramniwash
 */
public interface CustomerService {

	/**
	 * Save the new CustomerDTO to phone book
	 * 
	 * @param customerDTO the Contact reference object
	 * @return CustomerDTO the reference object
	 */
	public CustomerDTO saveCustomer(CustomerDTO customerDTO);
	
	/**
	 * Save the new CustomerDTO to phone book
	 * 
	 * @param customerDTO the Contact reference object
	 * @return CustomerDTO the reference object
	 */
	public CustomerDTO updateCustomer(CustomerDTO customerDTO);


	/**
	 * Get the CustomerDTO by contact id
	 * 
	 * @param customerId the long contact id
	 * @return CustomerDTO the reference object
	 */
	public CustomerDTO getCustomer(long customerId);

	/**
	 * Delete the CustomerDTO by id
	 * 
	 * @param customerId the long contact id
	 */
	public void deleteCustomerById(long customerId);

	/**
	 * Get all the CustomerDTOs by page
	 * 
	 * @param offset the index or offset
	 * @param size   the page size of limit of Contact
	 * @return Page of CustomerDTO
	 */
	public List<CustomerDTO> getAllCustomer(int offset, int size);
}
