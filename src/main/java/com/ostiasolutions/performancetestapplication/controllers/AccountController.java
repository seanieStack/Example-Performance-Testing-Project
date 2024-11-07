package com.ostiasolutions.performancetestapplication.controllers;

import com.ostiasolutions.performancetestapplication.entities.Account;
import com.ostiasolutions.performancetestapplication.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{accountNumber}"/*, produces = "application/json"*/)
    public Account getAccount(@PathVariable long accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{accountNumber}")
    public void deleteAccount(@PathVariable long accountNumber) {
        accountService.deleteAccount(accountNumber);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Account updateAccount(@Valid @RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
