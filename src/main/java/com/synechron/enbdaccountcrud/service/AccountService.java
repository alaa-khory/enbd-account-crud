package com.synechron.enbdaccountcrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.enbdaccountcrud.common.UserNotFoundException;
import com.synechron.enbdaccountcrud.model.Account;
import com.synechron.enbdaccountcrud.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public Account createAccount(Account account) {
		
		// set auto increment id
		account.setId(sequenceGeneratorService.getSequenctNumber(Account.SEQUENCE_NAME));
		
		return accountRepository.save(account);
	}

	public Account updateAccount(int id, Account accountWithNewDetails) {
		Optional<Account> updatedAccount = accountRepository.findById(id);

		if (updatedAccount.isEmpty()) {
			throw new UserNotFoundException("Account ID: (" + id + ") is not found!");
		}
		updatedAccount.get().setId(id);
		updatedAccount.get().setName(accountWithNewDetails.getName());
		updatedAccount.get().setTotalBalance(accountWithNewDetails.getTotalBalance());

		return accountRepository.save(updatedAccount.get());
	}

	public Account getAccountById(int id) {
		Optional<Account> account = accountRepository.findById(id);

		if (account.isEmpty())
			throw new UserNotFoundException("Account ID: (" + id + ") is not found!");

		return account.get();
	}
	
	public String deleteAccountById(int id) {
		Optional<Account> account = accountRepository.findById(id);
		if(account.isEmpty()) {
			throw new UserNotFoundException("Account ID: (" + id + ") is not found!");
		}
		
		accountRepository.deleteById(id);
		return "Account ID: (" + id + ") has been deleted successfuly!";
	}

}
