package com.cg.app.dao;

import java.util.List;

import com.cg.app.account.CurrentAccount;
import com.cg.app.exception.AccountNotFoundException;

public interface CurrentAccountDAO {

	CurrentAccount createNewAccount(CurrentAccount currentAccount) ;
	double checkCurrentBalance(int accountNumber) throws  AccountNotFoundException;
	CurrentAccount getAccountById(int accountNumber) throws AccountNotFoundException;
	CurrentAccount deleteAccount(int accountNumber);
	List<CurrentAccount> getAllSavingsAccount() ;
	void updateBalance(int accountNumber, double currentBalance);
	
	CurrentAccount updateAccount(CurrentAccount currentAccount) throws AccountNotFoundException;
	
	CurrentAccount getAccountByName(String accountHolderName) throws AccountNotFoundException;
	List<CurrentAccount> getAllAccountsBetweenSalaryRange(double mininumRange, double maximumRange);
	
	List<CurrentAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException;
}