package com.bulder;

import com.bulder.model.AccountStatus;
import com.bulder.model.AccountType;
import com.bulder.model.BankAccount;
import com.bulder.model.BankDirector;
import com.bulder.repository.AccountRepositoryImpl;

import java.util.List;

public class main {
    public static void main(String[] args){

//        BankAccount bankAccount = BankDirector.accountBuilder()
//                .accountId(1L)
//                .currency("MAD")
//                .status(AccountStatus.CREATED)
//                .type(AccountType.SAVING_ACCOUNT)
//                .balance(80000)
//                .build();
//
//        System.out.println(bankAccount.toString());

        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.populateData();

        List<BankAccount> bankAccounts = accountRepository.findAll();

        bankAccounts.forEach(System.out::println);

        System.out.println("=======================");

        BankAccount account = accountRepository.findById(1L).orElse(null);

        if(account!=null){
            System.out.println(account);
        }
    }
}
