package com.techhub.customer.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class CustomerDTO {

	private long customerId;

	@NotBlank(message = "Customer name is required")	
	@Pattern(regexp = "[A-Z{1}][a-zA-Z ]+", message = "Name should contain alphabets only and starts with upper case")
	private String customerName;

	@Min(value = 1000000000, message = "Mobile number should have 10 digits only")
	@Digits(fraction = 0, integer = 10, message = "Mobile number should have 10 digits only")
	private long mobileNumber;
	
	@NotBlank(message = "Email is required")	
	@Email(message = "Email is invalid")
	private String emailId;

	@Pattern(regexp = "[a-zA-Z0-9. ]+", message = "Description should contain alphabets")
	private String description;

	private LocalDate createdOn;

	private LocalDate updatedOn;

	@Digits(integer = 10, fraction = 3, message = "Invalid price")
	private BigDecimal price;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "Male|Female|Other", message = "Invalid Gender")
	private String gender;

	@Past(message = "Invalid date, it should be past date only")
	private Date dateOfBirth;

	private String[] servicesTaken;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String[] getServicesTaken() {
		return servicesTaken;
	}

	public void setServicesTaken(String[] servicesTaken) {
		this.servicesTaken = servicesTaken;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", description=" + description + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", price=" + price + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", servicesTaken=" + Arrays.toString(servicesTaken) + "]";
	}

}
