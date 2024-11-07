package com.ostiasolutions.performancetestapplication.services;

import com.ostiasolutions.performancetestapplication.entities.Account;
import com.ostiasolutions.performancetestapplication.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(long accountNumber) {
        return accountRepository.findDistinctByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }

    public Account createAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findDistinctByAccountNumber(account.getAccountNumber());

        if (existingAccount.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists with this name and account number.");
        }

        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(long accountNumber) {
        Optional<Account> optionalAccount = accountRepository.findDistinctByAccountNumber(accountNumber);
        if (optionalAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }

        accountRepository.deleteByAccountNumber(accountNumber);
    }

    public Account updateAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findDistinctByAccountNumber(account.getAccountNumber());

        if (existingAccount.isPresent()) {
            account.setId(existingAccount.get().getId());
            return accountRepository.save(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
    }
}
