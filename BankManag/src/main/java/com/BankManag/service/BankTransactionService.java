package com.BankManag.service;


import org.springframework.stereotype.Service;

import com.BankManag.Model.AccountDetailDTO;
@Service
public interface BankTransactionService {
	
	
	
	
	

	// defining custom methods to perform bank related operations

	String depositAmount(int accountId, String description, double depositAmount);

	String withdrawAmount(int accountId, String description, double withdrawAmount);

	AccountDetailDTO transactionHistory(int accountId);

	String fundTransfer(int senderAccountId, int receiverAccountId, double amount, String description);

}

