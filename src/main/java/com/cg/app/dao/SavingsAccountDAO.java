package com.cg.app.dao;

import java.util.List;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;

public interface SavingsAccountDAO {
	
	SavingsAccount createNewAccount(SavingsAccount account) ;
	double checkCurrentBalance(int accountNumber) throws  AccountNotFoundException;
	SavingsAccount getAccountById(int accountNumber) throws AccountNotFoundException;
	SavingsAccount deleteAccount(int accountNumber);
	List<SavingsAccount> getAllSavingsAccount() ;
	void updateBalance(int accountNumber, double currentBalance);
	//void commit() throws SQLException;
	SavingsAccount updateAccount(SavingsAccount savingAccount) throws AccountNotFoundException;
	
	SavingsAccount getAccountByName(String accountHolderName) throws AccountNotFoundException;
	List<SavingsAccount> getAllAccountsBetweenSalaryRange(double mininumRange, double maximumRange);
	
	List<SavingsAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException;
	
}
