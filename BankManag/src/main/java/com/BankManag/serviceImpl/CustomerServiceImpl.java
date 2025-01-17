package com.BankManag.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankManag.emailsender.EmailDetails;
import com.BankManag.emailsender.EmailServiceImpl;
import com.BankManag.entity.AccountDetail;
import com.BankManag.entity.Customer;
import com.BankManag.exception.AccountNotFoundException;
import com.BankManag.Model.CustomerDTO;
import com.BankManag.repository.AccountDetailRepository;
import com.BankManag.repository.CustomerRepository;
import com.BankManag.service.CustomerService;
import com.BankManag.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService {

    static Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

    // Creating instances for Repository and Converter
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    // CRUD Operations
    // Creating Account
    @Override
    public String createAccount(Customer customer) {

        // Check if accountDetail is null before setting its properties
        AccountDetail accountDetail = customer.getAccountDetail();

        if (accountDetail == null) {
            accountDetail = new AccountDetail(0, null, null, 0); // Initialize if null
        }

        String lastAddedAccountId = accountDetailRepository.getLastAddedAccountId();

        // If Last Account Id is null, initialize it with "0"
        if (lastAddedAccountId == null) {
            lastAddedAccountId = "0";
        }

        // Set account number and open date
        accountDetail.setAccountNumber(1000000000 + 1 + Integer.parseInt(lastAddedAccountId));
        accountDetail.setOpenDate(LocalDate.now());

        // Set the initialized accountDetail to customer
        customer.setAccountDetail(accountDetail);

        // Save customer with account details
        customerRepository.save(customer);

        log.info("Customer Account is Created at " + new java.util.Date());

        // Send email to customer about account creation
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(customer.getCustomerEmail());
        emailDetails.setSubject("Bank Account Created.");
        emailDetails.setMsgBody(customer.getCustomerName()
                + ", Your bank account has been created successfully with our  Bank PVT. LTD.\nKindly contact us for any issue.\nThank You");
        emailServiceImpl.sendSimpleMail(emailDetails);

        return "Account Created Successfully :)";
    }

    // Updating Account
    @Override
    public CustomerDTO updateAccountDetail(int customerId, Customer customer) {

        Customer foundCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new AccountNotFoundException("Customer", "Id", customerId));

        // If customer exists
        if (foundCustomer != null) {
            foundCustomer.setCustomerName(customer.getCustomerName());
            foundCustomer.setCustomerAddress(customer.getCustomerAddress());
            foundCustomer.setCustomerPanNo(customer.getCustomerPanNo());
            foundCustomer.setCustomerAdharNo(customer.getCustomerAdharNo());
            foundCustomer.setCustomerPhone(customer.getCustomerPhone());
            foundCustomer.setCustomerEmail(customer.getCustomerEmail());
            foundCustomer.setCustomerDateOfBirth(customer.getCustomerDateOfBirth());
            foundCustomer.setCustomerNationality(customer.getCustomerNationality());
            foundCustomer.setCustomerGender(customer.getCustomerGender());

            customerRepository.save(foundCustomer);
            log.info("Customer Account is Updated at " + new java.util.Date());

            return customerConverter.convertToCustomerDTO(foundCustomer);
        }

        return null;
    }

    // Getting customer by ID
    @Override
    public CustomerDTO getAccountDetailByCustomerId(int customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new AccountNotFoundException("Customer", "Id", customerId));

        log.info("Customer Searched at " + new java.util.Date());
        return customerConverter.convertToCustomerDTO(customer);
    }

    // Get All AccountDetails
    @Override
    public List<CustomerDTO> getAllAccountDetails() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        // For Each Loop
        for (Customer customer : customers) {
            customerDTOs.add(customerConverter.convertToCustomerDTO(customer));
        }

        return customerDTOs;
    }

    // CheckBalance using Customer Id
    @Override
    public String checkBalanceById(int customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new AccountNotFoundException("Customer", "Id", customerId));

        // If Customer exists
        if (customer != null) {
            return customer.getCustomerName() + " Jee, Your Account Balance is "
                    + customer.getAccountDetail().getAccountBalance();
        }
        log.error("Customer Account not found at " + new java.util.Date());
        return "Account not found";
    }

    // Get Customer using Name
    @Override
    public List<CustomerDTO> getCustomerByName(String customerName) {

        List<Customer> customerList = customerRepository.getCustomerByName(customerName);
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        // ForEach loop
        for (Customer c : customerList) {
            customerDTOs.add(customerConverter.convertToCustomerDTO(c));
        }
        return customerDTOs;
    }

	@Override
	public String createAccount(AccountDetail account) {
		// TODO Auto-generated method stub
		return null;
	}
}
