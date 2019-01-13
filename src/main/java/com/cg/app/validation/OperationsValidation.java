package com.cg.app.validation;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;

@Component
@Aspect
public class OperationsValidation {
	private Logger logger = Logger.getLogger(OperationsValidation.class.getName());

	@Around("execution (* com.cg.app.service.SavingsAccountServiceImpl.deposit(..))")
	public void aroundDeposit(ProceedingJoinPoint pjp) throws Throwable {
		Object[] params = pjp.getArgs();
		if ((Double) params[1] > 0) {
			pjp.proceed();
			logger.info("Deposit successful");
		} else
			throw new InvalidInputException("invalid input");
	}

	@Around("execution (* com.cg.app.service.SavingsAccountServiceImpl.withdraw(..))")
	public void aroundwithdraw(ProceedingJoinPoint pjp) throws Throwable {
		Object[] params = pjp.getArgs();

		if ((Double) params[1] > 0) {
			pjp.proceed();
			logger.info("Withdraw successful");
		} else {
			throw new InvalidInputException("wrong amount entered");
			// logger.info("Transaction Fail");

		}

	}
	

	@Around("execution (* com.cg.app.service.SavingsAccountServiceImpl.withdraw(..))")
	public void aroundgetAccId(ProceedingJoinPoint pjp) throws Throwable {
		Object[] params = pjp.getArgs();

		if ((Double) params[1] > 0) {
			pjp.proceed();
			logger.info("Withdraw successful");
		} else {
			throw new InvalidInputException("wrong amount entered");
			// logger.info("Transaction Fail");

		}

	}


	/*
	 * @AfterThrowing(pointcut =
	 * "execution (* com.cg.app.service.SavingsAccountServiceImpl.*(..))", throwing
	 * = "error") public void log5(Throwable error) {
	 * logger.info("Insufficient Funds in account"); }
	 */
}
