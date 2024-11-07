package com.ostiasolutions.performancetestapplication.controllers;

import com.ostiasolutions.performancetestapplication.entities.Account;
import com.ostiasolutions.performancetestapplication.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Get account by account number", description = "Get account by account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
    })
    @GetMapping(value = "/account/{accountNumber}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(@PathVariable long accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    @Operation(summary = "Create account", description = "Create account from body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created"),
            @ApiResponse(responseCode = "409", description = "Account already exists")
    })
    @PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @Operation(summary = "Delete account by account number", description = "Delete account by account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Account deleted"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @DeleteMapping("/account/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable long accountNumber) {
        accountService.deleteAccount(accountNumber);
    }

    @Operation(summary = "Update account", description = "Update account from body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated"),
            @ApiResponse(responseCode = "404", description = "Account provided not found")
    })
    @PutMapping(value = "/account", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
