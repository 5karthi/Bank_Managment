package com.BankManag.util;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.BankManag.entity.Customer;
import com.BankManag.Model.CustomerDTO;

@Component
public class CustomerConverter {

	// convert CustomerDTO to Entity(Customer)
	public Customer convertToEntity(CustomerDTO customerDTO) {

		Customer customer = new Customer(null, null, null, 0, 0, null, null, null, null, null);
		if (customerDTO != null) {
			BeanUtils.copyProperties(customerDTO, customer);
		}

		return customer;
	}

	// convert Customer to (CustomerDTO)
	public CustomerDTO convertToCustomerDTO(Customer customer) {

		CustomerDTO customerDTO = new CustomerDTO();
		if (customer != null) {
			BeanUtils.copyProperties(customer, customerDTO);
		}

		return customerDTO;
	}
}