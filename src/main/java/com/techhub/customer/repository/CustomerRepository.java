package com.techhub.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.customer.model.Customer;

/**
 * The ContactRepository for Contact
 * 
 * @author ramniwash
 */
@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
