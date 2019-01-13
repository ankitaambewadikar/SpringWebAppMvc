package com.cg.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.rowMapper.SavingsAccountMapper;

@Repository
@Primary
public class SavingsAccountSpringMVCDaoImpl implements SavingsAccountDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public SavingsAccount createNewAccount(SavingsAccount account) {
		System.out.println("injdbc dao");

		jdbctemplate.update("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)",
				new Object[] { account.getBankAccount().getAccountNumber(),
						account.getBankAccount().getAccountHolderName(), account.getBankAccount().getAccountBalance(),
						account.isSalary(), null, "SA" });

		return account;

	}

	@Override
	public double checkCurrentBalance(int accountNumber)
			throws AccountNotFoundException {

		return jdbctemplate.queryForObject("SELECT account_balance FROM account WHERE account_Id=?",
				new Object[] { accountNumber }, Double.class);

	}

	@Override
	public SavingsAccount getAccountById(int accountNumber)
			throws AccountNotFoundException {

		return jdbctemplate.queryForObject("SELECT * FROM account where account_id=?", new Object[] { accountNumber },
				new SavingsAccountMapper());
	}

	@Override
	public SavingsAccount deleteAccount(int accountNumber) {

		jdbctemplate.update("Delete FROM account WHERE account_Id=?", new Object[] { accountNumber });
		return null;

	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() {
		return jdbctemplate.query("SELECT * FROM ACCOUNT", new SavingsAccountMapper());
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) {
			jdbctemplate.update("UPDATE ACCOUNT SET account_balance=? where account_id=?",currentBalance,accountNumber);
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount savingAccount)
			throws AccountNotFoundException {
		jdbctemplate.update("UPDATE ACCOUNT SET account_hn=?,salary=? WHERE account_Id = ?", new Object[] {

				savingAccount.getBankAccount().getAccountHolderName(), savingAccount.isSalary(),
				savingAccount.getBankAccount().getAccountNumber() });
		return getAccountById(savingAccount.getBankAccount().getAccountNumber());
	}

	@Override
	public SavingsAccount getAccountByName(String accountHolderName)
			throws AccountNotFoundException {
		return jdbctemplate.queryForObject("SELECT * from account WHERE account_hn=?",
				new Object[] {accountHolderName}, new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> getAllAccountsBetweenSalaryRange(double mininumRange, double maximumRange) {
		return jdbctemplate.query("SELECT * FROM ACCOUNT WHERE account_balance BETWEEN ? AND ?",
				new Object[] { mininumRange, maximumRange }, new SavingsAccountMapper());
	}

	@Override
	public List<SavingsAccount> sortBy(int choice, int choiceSort)
			throws AccountNotFoundException {
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
		return jdbctemplate.query(query, new SavingsAccountMapper());
	}

}
