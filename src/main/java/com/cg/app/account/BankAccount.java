package com.cg.app.account;

public class BankAccount {
	private int accountNumber;
	private double accountBalance;
	private String accountHolderName;
	private String type;
	// private static int accountId;

	/*
	 * static { accountId = 100; }
	 */

	public BankAccount(int accountNumber, String accountHolderName, double accountBalance, String type) {

		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;

		this.type = type;
	}

	public BankAccount(String accountHolderName, double accountBalance) {
		// accountNumber = ++accountId;
		// this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(String accountHolderName) {
		// accountNumber = ++accountId;
		// this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
	}

	public BankAccount(int accountNumber, String accountHolderName, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountHolderName=" + accountHolderName + "]";
	}

}
