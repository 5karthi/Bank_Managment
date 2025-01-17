package com.BankManag.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// importing all the annotation from lombok for getter,setter and constructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bank_transactions") // creates table in database
public class BankTransactions {

	// instance variable for BankTransactions entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	// creating columns for table bank_transactions
	@Column(name = "date_of_transaction")
	private LocalDate dateOfTransaction;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "transaction_amount")
	private double transactionAmount;

	@Column(name = "description_of_transaction")
	private String descriptionOfTransaction;

	// this stores AccountDetail entity using many to one mapping
	// relationship

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private AccountDetail accountDetail;

	@Builder
	public BankTransactions() {
		super();
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.descriptionOfTransaction = descriptionOfTransaction;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getDescriptionOfTransaction() {
		return descriptionOfTransaction;
	}

	public void setDescriptionOfTransaction(String descriptionOfTransaction) {
		this.descriptionOfTransaction = descriptionOfTransaction;
	}

	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	}


