package com.BankManag.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

//importing all the annotation from lombok for getter,setter and constructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer") // creates table in the database
public class Customer {

    // instance variable for customer entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    // creating columns for table customer
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address", nullable = false)
    private String customerAddress;

    @Column(name = "customer_panno", nullable = false)
    private String customerPanNo;

    @Column(name = "customer_adharno", nullable = false)
    private long customerAdharNo;

    @Column(name = "customer_phone", nullable = false)
    private long customerPhone;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    // Adding new fields
    @Column(name = "customer_dob", nullable = false)
    private LocalDate customerDateOfBirth;  // Using LocalDate for date of birth

    @Column(name = "customer_nationality", nullable = false)
    private String customerNationality;

    @Column(name = "customer_gender", nullable = false)
    private String customerGender;

    // One-to-one relationship with AccountDetail entity
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JsonIgnore
    private AccountDetail accountDetail;

    @Builder
    public Customer(String customerName, String customerAddress, String customerPanNo, long customerAdharNo,
                    long customerPhone, String customerEmail, LocalDate customerDateOfBirth, 
                    String customerNationality, String customerGender, AccountDetail accountDetail) {
        super();
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPanNo = customerPanNo;
        this.customerAdharNo = customerAdharNo;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerNationality = customerNationality;
        this.customerGender = customerGender;
        this.accountDetail = accountDetail;
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPanNo() {
		return customerPanNo;
	}

	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}

	public long getCustomerAdharNo() {
		return customerAdharNo;
	}

	public void setCustomerAdharNo(long customerAdharNo) {
		this.customerAdharNo = customerAdharNo;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public LocalDate getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public String getCustomerNationality() {
		return customerNationality;
	}

	public void setCustomerNationality(String customerNationality) {
		this.customerNationality = customerNationality;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}
}