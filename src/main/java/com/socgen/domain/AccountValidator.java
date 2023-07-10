package com.socgen.domain;

import com.socgen.exceptions.AccountIllegalAmountException;
import com.socgen.exceptions.AccountNonSufficientFundException;

import java.math.BigDecimal;

public final class AccountValidator {
    public static void validateOperationAmount(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            throw new AccountIllegalAmountException();
        }
    }

    public static void validateAccountBalance(BigDecimal balance, BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new AccountNonSufficientFundException();
        }
    }
}
