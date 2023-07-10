package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.exceptions.AccountIllegalAmountException;
import com.socgen.exceptions.AccountNonSufficientFundException;

import java.math.BigDecimal;

public interface AccountService {
    void deposit(Account account, BigDecimal amount) throws AccountIllegalAmountException;

    void withdraw(Account account, BigDecimal amount) throws AccountIllegalAmountException, AccountNonSufficientFundException;
}
