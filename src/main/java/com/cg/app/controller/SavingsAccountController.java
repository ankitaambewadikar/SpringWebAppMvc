package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.service.SavingsAccountService;

@Controller
public class SavingsAccountController {

	@Autowired
	private SavingsAccountService service;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/createAccount")
	public String inputDetails() {
		return "addNewAccount";
	}

	@RequestMapping(value = "/addDetails", method = RequestMethod.GET)
	public String display(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBalance") double accountBalance, @RequestParam("isSalaried") boolean salary,
			Model model) {

		SavingsAccount newAccount = service.createNewAccount(accountHolderName, accountBalance, salary);
		model.addAttribute("account", newAccount);
		return "AccountDetails";

	}

	@RequestMapping("/getAllForm")
	public String getAllAccounts(Model model) {
		List<SavingsAccount> savingList = service.getAllSavingsAccount();
		model.addAttribute("accounts", savingList);
		return "AccountDetails";

	}

	@RequestMapping("/updateAccount")
	public String update() {
		return "updateForm";

	}

	@RequestMapping("/update")
	public String updateDetails(Model model, @RequestParam("txtAccountNumber") int accountNumber)
			throws AccountNotFoundException {
		SavingsAccount savingsAccount = service.getAccountById(accountNumber);
		model.addAttribute("account", savingsAccount);
		return "updateDetails";
	}

	@RequestMapping("/updatedb")
	public String updateDB(Model model, @RequestParam("txtAccountNumber") int accountNumber,
			@RequestParam("accountHolderName") String accountHolderName, @RequestParam("salary") String sal)
			throws AccountNotFoundException {
		boolean salary = sal.equalsIgnoreCase("yes") ? true : false;
		SavingsAccount savingsAccount = service.getAccountById(accountNumber);
		savingsAccount.getBankAccount().setAccountHolderName(accountHolderName);
		savingsAccount.setSalary(salary);
		service.updateAccount(savingsAccount);
		model.addAttribute("account", savingsAccount);
		return "AccountDetails";
	}

	@RequestMapping("/searchAccount")
	public String searchAccount() {
		return "SearchForm";

	}

	@RequestMapping(value = "/searchByAccountNumber", method = RequestMethod.GET)
	public String searchAccountById() {
		return "SearchByAccountNumber";

	}

	@RequestMapping(value = "/searchByAccountNumber", method = RequestMethod.POST)
	public String searchDbById(Model model, @RequestParam("txtAccountNumber") int accountNumber)
			throws AccountNotFoundException {
		SavingsAccount savingsAccount = service.getAccountById(accountNumber);
		model.addAttribute("account", savingsAccount);
		return "AccountDetails";
	}

	@RequestMapping("/search")
	public String searchAccountByAccountNumber() {
		return "SearchForm";

	}

	@RequestMapping(value = "/searchByAccountHolderName", method = RequestMethod.GET)
	public String searchAccountByName() {
		return "SearchByAccountHolderName";

	}

	@RequestMapping(value = "/searchByAccountHolderName", method = RequestMethod.POST)
	public String searchDbByName(Model model, @RequestParam("txtHolderNumber") String accountHolderName)
			throws AccountNotFoundException {
		SavingsAccount savingsAccount = service.getAccountByName(accountHolderName);
		System.out.println("insearchBy name");
		model.addAttribute("account", savingsAccount);
		return "AccountDetails";
	}

	@RequestMapping("/getCurrentBalance")
	public String checkCurrentBalance() {
		return "getCurrentBalanceForm";

	}

	@RequestMapping("/currentbalance")
	public String checkCurrentBalanceDb(Model model, @RequestParam("txtAccountNumber") int accountNumber)
			throws AccountNotFoundException {
		double currentBalance = service.checkCurrentBalance(accountNumber);
		model.addAttribute("account", currentBalance);
		return "display";
	}

	@RequestMapping("/deposit")
	public String deposit() {
		return "depositAmount";

	}

	@RequestMapping("/depositAmountInAccount")
	public String depositInAcc(Model model,@RequestParam("accountNumber") int accountNumber,
			@RequestParam("amounttodeposit") double amountDeposit) throws AccountNotFoundException {
		SavingsAccount savingsAccount = service.getAccountById(accountNumber);
		service.deposit(savingsAccount, amountDeposit);
		model.addAttribute("account",savingsAccount);
		return "result";

	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "withdrawAccount";

	}

	@RequestMapping("/withdrawAmountFromAccount")
	public String withdrawAmount(Model model,@RequestParam("accountNumber") int accountNumber,
			@RequestParam("amounttowithdraw") double amountWithdraw) throws AccountNotFoundException {
		SavingsAccount savingsAccount = service.getAccountById(accountNumber);
		service.withdraw(savingsAccount, amountWithdraw);
		model.addAttribute("account",savingsAccount);
		return "AccountDetails";

	}
	@RequestMapping("/fundTransfer")
	public String transferFund() {
		return "transfer";

	}

	
	  @RequestMapping("/fund") 
	  public String transferFundOperation(Model model, @RequestParam("senderAccountNumber") int senderAccountNumber,
			  		@RequestParam("receiverAccountNumber") int receiverAccountNumber,
			  		@RequestParam("amountToTransfer") double amountTransfer) throws AccountNotFoundException {
		 
	  SavingsAccount sender = service.getAccountById(senderAccountNumber);
	  SavingsAccount receiver = service.getAccountById(receiverAccountNumber);
	  service.fundTransfer(sender, receiver, amountTransfer);
	  return "result";
	  
	  }
	 
}
