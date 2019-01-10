package com.cg.app.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.app.account.SavingsAccount;
import com.cg.app.dao.SavingsAccountDAO;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;
import com.cg.app.factory.AccountFactory;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	// @Autowired
	private SavingsAccountDAO savingsAccountDAO;

	@Autowired
	public SavingsAccountServiceImpl(SavingsAccountDAO savingsAccountDAO) {
		factory = AccountFactory.getInstance();
		this.savingsAccountDAO = savingsAccountDAO;
	}

	public SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary) {
		SavingsAccount account = factory.createNewSavingsAccount(accountHolderName, accountBalance, salary);
		return savingsAccountDAO.createNewAccount(account);
	}

	public List<SavingsAccount> getAllSavingsAccount() {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	public void deposit(SavingsAccount account, double amount) {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	public void withdraw(SavingsAccount account, double amount) {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}
	}

	@Transactional
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount) {

		withdraw(sender, amount);
		deposit(receiver, amount);
//		withdraw(sender, amount);
	}

	public SavingsAccount getAccountById(int accountNumber) throws AccountNotFoundException {
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	public SavingsAccount deleteAccount(int accountNumber) throws AccountNotFoundException {

		return savingsAccountDAO.deleteAccount(accountNumber);
	}

	public double checkCurrentBalance(int accountNumber) throws AccountNotFoundException {

		return savingsAccountDAO.checkCurrentBalance(accountNumber);
	}

	public SavingsAccount updateAccount(SavingsAccount account) throws AccountNotFoundException {
		return savingsAccountDAO.updateAccount(account);
	}

	public SavingsAccount getAccountByName(String accountHolderName) throws AccountNotFoundException {

		return savingsAccountDAO.getAccountByName(accountHolderName);
	}

	public List<SavingsAccount> getAllAccountsBetweenSalaryRange(double minimumRange, double maximumRange) {

		return savingsAccountDAO.getAllAccountsBetweenSalaryRange(minimumRange, maximumRange);
	}

	@Override
	public List<SavingsAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException {

		return savingsAccountDAO.sortBy(choice, choiceSort);
	}

}
