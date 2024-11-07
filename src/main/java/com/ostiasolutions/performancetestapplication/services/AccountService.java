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
        if (!accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }

        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(long accountNumber) {
        if (!accountRepository.existsByAccountNumber(accountNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }

        accountRepository.deleteByAccountNumber(accountNumber);
    }

    @Transactional
    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findDistinctByAccountNumber(account.getAccountNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        account.setId(existingAccount.getId());
        return accountRepository.save(account);
    }
}
