package ie.seaniestack.performancetestapplication.repositories;

import ie.seaniestack.performancetestapplication.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findDistinctByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(String firstName, String lastName, long accountNumber);

    void deleteByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndAccountNumber(String firstName, String lastName, long accountNumber);
}
