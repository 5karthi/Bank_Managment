package com.BankManag.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import com.BankManag.entity.Customer;
import com.BankManag.Model.CustomerDTO;
import com.BankManag.service.CustomerService;
import com.BankManag.util.CustomerConverter;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CustomerController {
	

	    @Autowired
	    private CustomerService customerService;

	    @Autowired
	    private CustomerConverter customerConverter;

	    // ----------------- JSP Mappings --------------------
	   // http://localhost:8080/createAccount
	    
	    // For creating customer account via form (JSP)
	    @PostMapping("/createAccount")
	    public String createAccount(@RequestParam String customerName, @RequestParam String customerEmail,
	                                @RequestParam String customerPhone, @RequestParam double balance,
	                                @RequestParam String customerAddress, @RequestParam String customerPanNo,
	                                @RequestParam long customerAdharNo, @RequestParam String customerDob, 
	                                @RequestParam String customerNationality, @RequestParam String customerGender, 
	                                Model model) {

	        LocalDate dob = LocalDate.parse(customerDob);
	        CustomerDTO customerDTO = new CustomerDTO(customerName, customerEmail, customerPhone, balance, 
	                                                  customerAddress, customerPanNo, customerAdharNo, 
	                                                  dob, customerNationality, customerGender);
	        
	        Customer customer = customerConverter.convertToEntity(customerDTO);
	        String result = customerService.createAccount(customer);
	        model.addAttribute("message", result);

	        return "result";  // JSP file to display the result
	    }

	    //http://localhost:8080/updateAccount
	    // For updating customer account details via JSP form
	    @PostMapping("/updateAccount")
	    public String updateAccountDetail(@RequestParam int accountId, @RequestParam(required = false) String customerName,
	                                      @RequestParam(required = false) String customerEmail,
	                                      @RequestParam(required = false) String customerPhone, 
	                                      @RequestParam(required = false) String customerAddress,
	                                      @RequestParam(required = false) String customerPanNo, 
	                                      @RequestParam(required = false) Long customerAdharNo,
	                                      @RequestParam(required = false) String customerDob, 
	                                      @RequestParam(required = false) String customerNationality,
	                                      @RequestParam(required = false) String customerGender, 
	                                      Model model) {

	        LocalDate dob = (customerDob != null) ? LocalDate.parse(customerDob) : null;
	        CustomerDTO customerDTO = new CustomerDTO(customerName, customerEmail, customerPhone, 0.0, 
	                                                  customerAddress, customerPanNo, customerAdharNo, 
	                                                  dob, customerNationality, customerGender);
	        
	        Customer customer = customerConverter.convertToEntity(customerDTO);
	        CustomerDTO updatedCustomer = customerService.updateAccountDetail(accountId, customer);
	        model.addAttribute("customer", updatedCustomer);

	        return "viewCustomerDetails";  // JSP file to display the customer details
	    }

	  //http://localhost:8080/getAccountDetailByCustomerId
	    
	    // Fetching account details and displaying in JSP
	    @GetMapping("/getAccountDetailByCustomerId")
	    public String getAccountDetailByCustomerId(@RequestParam int accountId, Model model) {
	        CustomerDTO customerDTO = customerService.getAccountDetailByCustomerId(accountId);
	        model.addAttribute("customer", customerDTO);
	        return "viewCustomerDetails";  // JSP page
	    }

	    
	  //http://localhost:8080/checkBalance
	    // Checking balance via JSP form
	    @GetMapping("/checkBalance")
	    public String checkBalance(@RequestParam int accountId, Model model) {
	        String result = customerService.checkBalanceById(accountId);
	        model.addAttribute("message", result);
	        return "result";  // JSP page to display the balance
	    }

	    // ----------------- JSON API Mappings --------------------

	    // For creating customer account via JSON API (POSTMAN)
	    @PostMapping("/api/createAccount")
	    public @ResponseBody String createAccountAPI(@RequestBody CustomerDTO customerDTO) {
	        Customer customer = customerConverter.convertToEntity(customerDTO);
	        return customerService.createAccount(customer);
	    }

	    // For updating customer account via API (POSTMAN)
	    @PostMapping("/api/updateAccount")
	    public @ResponseBody CustomerDTO updateAccountDetailAPI(@RequestParam int accountId, @RequestBody CustomerDTO customerDTO) {
	        Customer customer = customerConverter.convertToEntity(customerDTO);
	        return customerService.updateAccountDetail(accountId, customer);
	    }

	    // Fetching customer details via API (JSON response)
	    @GetMapping("/api/getAccountDetailByCustomerId")
	    public @ResponseBody CustomerDTO getAccountDetailByCustomerIdAPI(@RequestParam int accountId) {
	        return customerService.getAccountDetailByCustomerId(accountId);
	    }

	    // Checking balance via API (JSON response)
	    @GetMapping("/api/checkBalance")
	    public @ResponseBody String checkBalanceAPI(@RequestParam int accountId) {
	        return customerService.checkBalanceById(accountId);
	    }

	    // Fetch customer by name (JSON response)
	    @GetMapping("/api/customerByName")
	    public @ResponseBody List<CustomerDTO> getCustomerByNameAPI(@RequestParam String customerName) {
	        return customerService.getCustomerByName(customerName);
	    }
	}
