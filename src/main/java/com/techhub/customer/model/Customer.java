package com.techhub.customer.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Contact persistance class
 * 
 * @author ramniwash
 */
@Entity
@Table(schema = "customer_service",name = "customers")
public class Customer {

	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;

	@Column(name = "CONTACT_NAME", length = 50, nullable = false)
	private String customerName;

	@Column(name = "MOBILE_NUMBER", length = 255, nullable = false)
	private long mobileNumber;

	@Column(name = "EMAILS", length = 255, nullable = false)
	private String emailId;

	@Column(name = "CREATED_ON")
	@CreationTimestamp
	private LocalDate createdOn;

	@Column(name = "UPDATED_ON")
	@UpdateTimestamp
	private LocalDate updatedOn;

	@Column(name = "DESCRIPTION", length = 255, nullable = true)
	private String description;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "GENDER", length = 10, nullable = true)
	private String gender;

	@Column(name = "DATE_OF_BIRTH", nullable = true)
	private Date dateOfBirth;

	@Column(name = "SERVICES_TAKEN", nullable = true)
	private String servicesTaken;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getServicesTaken() {
		return servicesTaken;
	}

	public void setServicesTaken(String servicesTaken) {
		this.servicesTaken = servicesTaken;
	}

	@Override
	public String toString() {
		return String.valueOf(customerId);
	}
}
