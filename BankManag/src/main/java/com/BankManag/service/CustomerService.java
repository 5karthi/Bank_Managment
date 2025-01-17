package com.BankManag.service;


import java.util.List;

import com.BankManag.entity.AccountDetail;
import com.BankManag.entity.Customer;
import com.BankManag.Model.CustomerDTO;

public interface CustomerService {

	// defining methods to perform customer and account related operations
	String createAccount(AccountDetail account);

	CustomerDTO updateAccountDetail(int id, Customer customerId);

	CustomerDTO getAccountDetailByCustomerId(int customerId);

	List<CustomerDTO> getAllAccountDetails();

	String checkBalanceById(int customerId);

	List<CustomerDTO> getCustomerByName(String customerName);

	String createAccount(Customer customer);

}

