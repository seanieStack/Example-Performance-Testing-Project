package ie.seaniestack.performancetestapplication.services;

import ie.seaniestack.performancetestapplication.entities.Account;
import ie.seaniestack.performancetestapplication.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(String firstName, String lastName, long accountNumber) {

        Optional<Account> account = accountRepository.findDistinctByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(firstName, lastName, accountNumber);

        return account.orElse(null);
    }

    public Account createAccount(Account account) {
//        Account newAccount = new Account();
//        newAccount.setAccountNumber(account.getAccountNumber());
//        newAccount.setFirstName(account.getFirstName());
//        newAccount.setLastName(account.getLastName());
//        newAccount.setTitle(account.getTitle());
//        newAccount.setEmail(account.getEmail());
//        newAccount.setAddress(account.getAddress());
//        newAccount.setCity(account.getCity());
//        newAccount.setCountry(account.getCountry());
//        newAccount.setPhoneNumber(account.getPhoneNumber());
//        newAccount.setOccupation(account.getOccupation());
//        newAccount.setGender(account.getGender());
//        newAccount.setBirthDate(account.getBirthDate());
//        newAccount.setBranchCode(account.getBranchCode());
//        newAccount.setBalance(account.getBalance());
//        newAccount.setBalance(account.getBalance());
//        newAccount.setCreditLimit(account.getCreditLimit());
//        newAccount.setAccountType(account.getAccountType());
//        newAccount.setActive(account.isActive());
//        newAccount.setCurrency(account.getCurrency());
//        newAccount.setMonthlyTransactionLimit(account.getMonthlyTransactionLimit());
//        newAccount.setOverdraftEnabled(account.isOverdraftEnabled());
        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(String firstName, String lastName, long accountNumber) {
        accountRepository.deleteByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(firstName, lastName, accountNumber);
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
