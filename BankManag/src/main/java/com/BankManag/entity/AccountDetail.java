package com.BankManag.entity;

	import java.time.LocalDate;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	import lombok.AllArgsConstructor;
	import lombok.Builder;
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
    @Entity
	@Table(name = "account") // creates table in database
	public class AccountDetail {

		// instance variable for AccountDetail entity
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int accountId;

		// creating columns for table account

		@Column(name = "account_number")
		private long accountNumber;

		@Column(name = "open_date")
		private LocalDate openDate;
		
		@Column(nullable = false) // Ensure this field is not nullable
	    private String accountType;
		
		@Column(name = "account_balance", nullable = false)
		private double accountBalance;

		// this connect with BankTransactions entity using one to many mapping
		// relationship

		@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
				CascadeType.REMOVE }, fetch = FetchType.LAZY)
		@JsonIgnore
		private List<BankTransactions> bankTransactions;

		@Builder
		public AccountDetail(long accountNumber, LocalDate openDate, String accountType, double accountBalance) {
			super();
			this.accountNumber = accountNumber;
			this.openDate = openDate;
			this.accountType = accountType;
			this.accountBalance = accountBalance;
			
		}

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

		public AccountDetail(int accountId, LocalDate openDate, String accountType, double accountBalance, List<BankTransactions> bankTransactions, long accountNumber) {
			super();
			this.accountId = accountId;
			this.accountNumber = accountNumber;
			this.openDate = openDate;
			this.accountType = accountType;
			this.accountBalance = accountBalance;
			this.bankTransactions = bankTransactions;
		}

	}