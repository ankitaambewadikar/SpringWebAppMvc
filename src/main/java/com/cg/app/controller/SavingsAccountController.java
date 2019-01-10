package com.cg.app.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.app.account.SavingsAccount;
import com.cg.app.service.SavingsAccountService;

@Controller
public class SavingsAccountController {

	@Autowired
	SavingsAccountService service;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("getAllForm")
	public String getAllAccounts(Model model) {

		List<SavingsAccount> savingList = service.getAllSavingsAccount();
		model.addAttribute("accounts", savingList);
		return "AccountDetails";

	}

	@RequestMapping("updateAccount")
	public String update() {

		return "searchForm";

	}

	/*
	 * @RequestMapping("/search") public String
	 */
}
