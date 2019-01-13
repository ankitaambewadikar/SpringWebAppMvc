package com.cg.app.service;

import java.util.List;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;

public interface SavingsAccountService {

	SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary);

	SavingsAccount updateAccount(SavingsAccount account) throws AccountNotFoundException;

	SavingsAccount getAccountById(int accountNumber) throws AccountNotFoundException;

	SavingsAccount deleteAccount(int accountNumber) throws AccountNotFoundException;

	List<SavingsAccount> getAllSavingsAccount();

	double checkCurrentBalance(int accountNumber) throws AccountNotFoundException;

	void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount);

	void deposit(SavingsAccount account, double amount);

	void withdraw(SavingsAccount account, double amount);

	SavingsAccount getAccountByName(String accountHolderName) throws AccountNotFoundException;

	List<SavingsAccount> getAllAccountsBetweenSalaryRange(double minimumRange, double maximumRange);

	List<SavingsAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException;
}
