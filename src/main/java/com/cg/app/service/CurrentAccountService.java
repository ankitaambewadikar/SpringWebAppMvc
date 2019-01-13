package com.cg.app.service;

import java.util.List;

import com.cg.app.account.CurrentAccount;
import com.cg.app.exception.AccountNotFoundException;

public interface CurrentAccountService {
	CurrentAccount createNewAccount(String accountHolderName, double accountBalance, double odLimit);

	CurrentAccount updateAccount(CurrentAccount account) throws AccountNotFoundException;

	CurrentAccount getAccountById(int accountNumber) throws AccountNotFoundException;

	CurrentAccount deleteAccount(int accountNumber) throws AccountNotFoundException;

	List<CurrentAccount> getAllSavingsAccount();

	double checkCurrentBalance(int accountNumber) throws AccountNotFoundException;

	void fundTransfer(CurrentAccount sender, CurrentAccount receiver, double amount);

	void deposit(CurrentAccount account, double amount);

	void withdraw(CurrentAccount account, double amount);

	CurrentAccount getAccountByName(String accountHolderName) throws AccountNotFoundException;

	List<CurrentAccount> getAllAccountsBetweenSalaryRange(double minimumRange, double maximumRange);

	List<CurrentAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException;
}