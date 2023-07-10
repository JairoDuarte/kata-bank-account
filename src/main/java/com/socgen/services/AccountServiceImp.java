package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.domain.Operation;
import com.socgen.domain.OperationType;
import com.socgen.exceptions.AccountIllegalAmountException;
import com.socgen.exceptions.AccountNonSufficientFundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountServiceImp implements AccountService {
    @Override
    public void deposit(Account account, BigDecimal amount) throws AccountIllegalAmountException {
        account.deposit(amount);

        account.addOperation(Operation.builder()
                .operationType(OperationType.Deposit)
                .date(LocalDateTime.now())
                .balance(account.getBalance())
                .amount(amount)
                .build());
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) throws AccountIllegalAmountException, AccountNonSufficientFundException {
        account.withdraw(amount);

        account.addOperation(Operation
                .builder()
                .operationType(OperationType.Withdraw)
                .date(LocalDateTime.now())
                .balance(account.getBalance())
                .amount(amount)
                .build());
    }
}
