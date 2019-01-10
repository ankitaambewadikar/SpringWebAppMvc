package com.cg.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.app.account.BankAccount;
import com.cg.app.account.SavingsAccount;

public class SavingsAccountMapper implements RowMapper<SavingsAccount> {

	@Override
	public SavingsAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("In map " +rs.getInt("account_id"));
		//if(rs.getInt("account_id"))
		return new SavingsAccount(rs.getInt("account_id"), rs.getString("account_hn"), rs.getDouble("account_balance"),
				rs.getBoolean("salary"));

	}

}
