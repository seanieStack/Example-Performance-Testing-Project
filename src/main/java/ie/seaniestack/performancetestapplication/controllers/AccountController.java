package ie.seaniestack.performancetestapplication.controllers;

import ie.seaniestack.performancetestapplication.entities.Account;
import ie.seaniestack.performancetestapplication.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{firstName}/{lastName}/{accountNumber}")
    public Account getAccount(@PathVariable String firstName, @PathVariable String lastName, @PathVariable long accountNumber) {
        return accountService.getAccount(firstName, lastName, accountNumber);
    }

    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{firstName}/{lastName}/{accountNumber}")
    public void deleteAccount(@PathVariable String firstName, @PathVariable String lastName, @PathVariable long accountNumber) {
        accountService.deleteAccount(firstName, lastName, accountNumber);
    }

    @PutMapping
    public Account updateAccount(@Valid @RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
