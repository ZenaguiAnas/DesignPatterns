package com.bulder.repository;

import com.bulder.model.AccountStatus;
import com.bulder.model.AccountType;
import com.bulder.model.BankAccount;
import com.bulder.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    private static final AccountRepositoryImpl accountRepository;

    static {
        System.out.println("Singleton instantiation");
        accountRepository = new AccountRepositoryImpl();
    }
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    private AccountRepositoryImpl(){}

    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId = ++accountsCount;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
        if(account == null) return Optional.empty();
        return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public void populateData(){
        for (int i = 1; i < 10; i++) {
            BankAccount account = BankDirector.accountBuilder()
                    .balance(10000+Math.random()*90000)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.CREATED: AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5? "MAD": "USD")
                    .build();

            save(account);
        }
    }

    public static AccountRepositoryImpl getInstance(){
        return accountRepository;
    }
}
