package com.bulder;

import com.bulder.model.AccountStatus;
import com.bulder.model.AccountType;
import com.bulder.model.BankAccount;
import com.bulder.model.BankDirector;

public class main {
    public static void main(String[] args){

        BankAccount bankAccount = BankDirector.accountBuilder()
                .accountId(1L)
                .currency("MAD")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(80000)
                .build();

        System.out.println(bankAccount.toString());
    }
}
