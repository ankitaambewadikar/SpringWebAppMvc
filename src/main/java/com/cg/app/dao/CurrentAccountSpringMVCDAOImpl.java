package com.cg.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.account.CurrentAccount;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.rowMapper.CurrentAccountMapper;
import com.cg.app.rowMapper.SavingsAccountMapper;
@Repository
public class CurrentAccountSpringMVCDAOImpl implements CurrentAccountDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public CurrentAccount createNewAccount(CurrentAccount currentAccount) {
		jdbctemplate.update("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)",
				new Object[] { currentAccount.getBankAccount().getAccountNumber(),
						currentAccount.getBankAccount().getAccountHolderName(), currentAccount.getBankAccount().getAccountBalance(),
						null, currentAccount.getOdLimit(), "CA" });

		return currentAccount;
	}

	@Override
	public double checkCurrentBalance(int accountNumber) throws AccountNotFoundException {
		
		return jdbctemplate.queryForObject("SELECT account_balance FROM account WHERE account_Id=?",
				new Object[] { accountNumber }, Double.class);

	}

	@Override
	public CurrentAccount getAccountById(int accountNumber) throws AccountNotFoundException {
		return jdbctemplate.queryForObject("SELECT * FROM account where account_id=?", new Object[] { accountNumber },
				new CurrentAccountMapper());
	}

	@Override
	public CurrentAccount deleteAccount(int accountNumber) {
		jdbctemplate.update("Delete FROM account WHERE account_Id=?", new Object[] { accountNumber });
		return null;
	}

	@Override
	public List<CurrentAccount> getAllSavingsAccount() {
		return jdbctemplate.query("SELECT * FROM ACCOUNT", new CurrentAccountMapper());
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) {
		jdbctemplate.update("UPDATE ACCOUNT SET account_balance=? where account_id=?",currentBalance,accountNumber);
		
	}

	@Override
	public CurrentAccount updateAccount(CurrentAccount currentAccount) throws AccountNotFoundException {
		jdbctemplate.update("UPDATE ACCOUNT SET account_hn=?,salary=? WHERE account_Id = ?", new Object[] {

				currentAccount.getBankAccount().getAccountHolderName(), currentAccount.getOdLimit(),
				currentAccount.getBankAccount().getAccountNumber() });
		return getAccountById(currentAccount.getBankAccount().getAccountNumber());
	}

	@Override
	public CurrentAccount getAccountByName(String accountHolderName) throws AccountNotFoundException {
		return jdbctemplate.queryForObject("SELECT * from account WHERE account_hn=?",
				new Object[] {accountHolderName}, new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> getAllAccountsBetweenSalaryRange(double mininumRange, double maximumRange) {
		return jdbctemplate.query("SELECT * FROM ACCOUNT WHERE account_balance BETWEEN ? AND ?",
				new Object[] { mininumRange, maximumRange }, new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> sortBy(int choice, int choiceSort) throws AccountNotFoundException {
		String query = " ";
		switch (choice) {
		case 1:

			if (choiceSort == 1) {
				query = "SELECT * From account ORDER BY account_Id";
			} else
				query = "SELECT * From account ORDER BY account_Id DESC";
			break;
		case 2:
			if (choiceSort == 1)
				query = "SELECT * From account ORDER BY account_hn";
			else
				query = "SELECT * From account ORDER BY account_hn DESC";
			break;
		case 3:
			if (choiceSort == 1)
				query = "SELECT * From account ORDER BY account_balance ";
			else
				query = "SELECT * From account ORDER BY account_balance DESC";
			break;
		}
		return jdbctemplate.query(query, new CurrentAccountMapper());
	}
	
}
