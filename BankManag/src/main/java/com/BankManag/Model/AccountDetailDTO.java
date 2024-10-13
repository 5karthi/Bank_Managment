package com.BankManag.Model;



import java.time.LocalDate;
import java.util.List;

import com.BankManag.entity.BankTransactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//importing all the annotation from lombok for getter,setter and constructor

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDetailDTO { // DTO class to store object

	// copy of instance variable created 
	private int accountId;

	private long accountNumber;

	private LocalDate openDate;

	private String accountType;

	private double accountBalance;

	private List<BankTransactions> bankTransactions;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<BankTransactions> getBankTransactions() {
		return bankTransactions;
	}

	public void setBankTransactions(List<BankTransactions> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
}