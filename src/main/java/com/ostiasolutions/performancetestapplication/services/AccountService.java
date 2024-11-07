package com.ostiasolutions.performancetestapplication.services;

import com.ostiasolutions.performancetestapplication.entities.Account;
import com.ostiasolutions.performancetestapplication.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(long accountNumber) {

        Optional<Account> account = accountRepository.findDistinctByAccountNumber(accountNumber);

        return account.orElse(null);
    }

    public Account createAccount(Account account) {

        Optional<Account> existingAccount = accountRepository.findDistinctByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(account.getFirstName(), account.getLastName(), account.getAccountNumber());

        if (existingAccount.isPresent()) {
            return null;
        }

        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(long accountNumber) {
        accountRepository.deleteByAccountNumber(accountNumber);
    }

    public Account updateAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findDistinctByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(account.getFirstName(), account.getLastName(), account.getAccountNumber());

        if (existingAccount.isPresent()) {
            account.setId(existingAccount.get().getId());
            return accountRepository.save(account);
        } else {
            return null;
        }
    }
}
