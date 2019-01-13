package com.cg.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.app.account.CurrentAccount;

public class CurrentAccountMapper implements RowMapper<CurrentAccount> {

	@Override
	public CurrentAccount mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new CurrentAccount(rs.getInt("account_id"), rs.getString("account_hn"), rs.getDouble("account_balance"),
				rs.getDouble("od_Limit"),rs.getString("type"));
	}

}
