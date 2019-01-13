package com.cg.app.account;

public class CurrentAccount {

	private double odLimit;
	private BankAccount bankAccount;

	public CurrentAccount(int accountNumber,String accountHolderName, double accountBalance, double odLimit,String type) {
		this.bankAccount = new BankAccount(accountNumber,accountHolderName, accountBalance,type);
		this.odLimit = odLimit;

	}
	
	public CurrentAccount(String accountHolderName, double accountBalance, double odLimit) {
		this.bankAccount = new BankAccount(accountHolderName, accountBalance);
		this.odLimit = odLimit;

	}
	
	public CurrentAccount(String accountHolderName, double odLimit) {
		this.bankAccount = new BankAccount(accountHolderName);
		this.odLimit = odLimit;

	}

	public CurrentAccount(int accountNumber,String accountHolderName, double accountBalance, double odLimit) {
		this.bankAccount = new BankAccount(accountNumber,accountHolderName, accountBalance);
		this.odLimit = odLimit;

	}
	
	public CurrentAccount() {
		
	}

	public double getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(double odLimit) {
		this.odLimit = odLimit;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
}
