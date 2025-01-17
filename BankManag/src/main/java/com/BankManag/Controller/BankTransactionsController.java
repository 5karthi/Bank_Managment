package com.BankManag.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankManag.Model.AccountDetailDTO;
import com.BankManag.service.BankTransactionService;
import com.BankManag.util.BankTransactionsConverter;

@RestController
public class BankTransactionsController {

	@Autowired
	BankTransactionService bankTransactionService;

	@Autowired
	BankTransactionsConverter bankTransactionConverter;
	
	
	 // http://localhost:8080//deposit/{id}/{desc}/{amount}
    
	@PostMapping("/deposit/{id}/{desc}/{amount}")
	public String depositAmount(@PathVariable("id") int accountId, @PathVariable("desc") String description,
			@PathVariable("amount") double depositAmount) {
		return bankTransactionService.depositAmount(accountId, description, depositAmount);
	}

	@PostMapping("/withdraw/{id}/{desc}/{amount}")
	public String withdrawAmount(@PathVariable("id") int accountId, @PathVariable("desc") String description,
			@PathVariable("amount") double withdrawAmount) {
		return bankTransactionService.withdrawAmount(accountId, description, withdrawAmount);
	}

	@GetMapping("/transactionHistory/{id}")
	public AccountDetailDTO printPassbook(@PathVariable("id") int id) {
		return bankTransactionService.transactionHistory(id);
	}

	@PostMapping("/fundTransfer/{senderAccountId}/{receiverAccountId}/{amount}/{desc}")
	public String fundTransfer(@PathVariable("senderAccountId") int senderAccountId,
			@PathVariable("receiverAccountId") int receiverAccountId, @PathVariable("amount") double amount,
			@PathVariable("desc") String description) {
		return bankTransactionService.fundTransfer(senderAccountId, receiverAccountId, amount, description);
	}

}