package com.ostiasolutions.performancetestapplication.repositories;

import com.ostiasolutions.performancetestapplication.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findDistinctByAccountNumber(long accountNumber);

    void deleteByAccountNumber(long AccountNumber);

    boolean existsByAccountNumber(long accountNumber);
}
