package com.techhub.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techhub.customer.adaptor.CustomerAdaptor;
import com.techhub.customer.dto.CustomerDTO;
import com.techhub.customer.model.Customer;
import com.techhub.customer.repository.CustomerRepository;

/**
 * The ContactService implementation
 * 
 * @author ramniwash
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		return CustomerAdaptor.toContactDTO(this.customerRepository.save(CustomerAdaptor.toContact(customerDTO)));
	}

	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		return CustomerAdaptor.toContactDTO(this.customerRepository.save(CustomerAdaptor.toContact(customerDTO)));
	}

	@Override
	public CustomerDTO getCustomer(long contactId) {
		return CustomerAdaptor.toContactDTO(this.customerRepository.getReferenceById(contactId));
	}

	@Override
	public void deleteCustomerById(long contactId) {
		this.customerRepository.deleteById(contactId);
	}

	@Override
	public List<CustomerDTO> getAllCustomer(int offset, int size) {
		Page<Customer> customers = this.customerRepository.findAll(PageRequest.of(offset, size));
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		for (Customer customer : customers) {
			customerDTOs.add(CustomerAdaptor.toContactDTO(customer));
		}
		return customerDTOs;
	}
}
