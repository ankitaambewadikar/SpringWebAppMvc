package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.app.account.CurrentAccount;
import com.cg.app.dao.CurrentAccountDAO;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;
import com.cg.app.factory.CurrentAccountFactory;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {

	private CurrentAccountFactory currentFactory;
	private CurrentAccountDAO currentAccountDAO;

	@Autowired
	public CurrentAccountServiceImpl(CurrentAccountDAO currentAccountDAO) {
		currentFactory = CurrentAccountFactory.getInstance();
		this.currentAccountDAO = currentAccountDAO;
	}

	
	public CurrentAccount createNewAccount(String accountHolderName, double accountBalance, double odLimit) {
		CurrentAccount account = currentFactory.createNewCurrentAccount(accountHolderName, accountBalance, odLimit);
		return currentAccountDAO.createNewAccount(account);
	}

	
	public CurrentAccount updateAccount(CurrentAccount account) throws AccountNotFoundException {
		return currentAccountDAO.updateAccount(account);
	}

	
	public CurrentAccount getAccountById(int accountNumber) throws AccountNotFoundException {
		return currentAccountDAO.getAccountById(accountNumber);
	}

	
	public CurrentAccount deleteAccount(int accountNumber) throws AccountNotFoundException {
		return currentAccountDAO.deleteAccount(accountNumber);
	}

	
	public List<CurrentAccount> getAllSavingsAccount() {
		return currentAccountDAO.getAllSavingsAccount();
	}

	
	public double checkCurrentBalance(int accountNumber) throws AccountNotFoundException {
		return currentAccountDAO.checkCurrentBalance(accountNumber);
	}

	@Transactional
	public void fundTransfer(CurrentAccount sender, CurrentAccount receiver, double amount) {
		withdraw(sender, amount);
		deposit(receiver, amount);

	}

	@Transactional
	public void deposit(CurrentAccount account, double amount) {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			currentAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);

		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	@Transactional
	public void withdraw(CurrentAccount account, double amount) {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			currentAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);

		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}

	}

	
	public CurrentAccount getAccountByName(String accountHolderName) throws AccountNotFoundException {
		return currentAccountDAO.getAccountByName(accountHolderName);
	}

	
	public List<CurrentAccount> getAllAccountsBetweenSalaryRange(double minimumRange, double maximumRange) {
		return currentAccountDAO.getAllAccountsBetweenSalaryRange(minimumRange, maximumRange);
	}

	
	public List<CurrentAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException {
		return currentAccountDAO.sortBy(choice, choiceSort);
	}

}
