package com.bulder.repository;

import com.bulder.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id); // Soit return the object BankAccount or nothing
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount account);
    void deleteById(Long id);

}
