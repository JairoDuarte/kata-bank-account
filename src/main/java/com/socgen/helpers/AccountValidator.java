package com.socgen.helpers;

import com.socgen.exceptions.AccountIllegalAmountException;
import com.socgen.exceptions.AccountNonSufficientFundException;

import java.math.BigDecimal;

public final class AccountValidator {
    public static void validateOperationAmount(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            throw new AccountIllegalAmountException(String.format("amount %s is less or equal to 0, it must be more than 0", amount.toString()));
        }
    }

    public static void validateAccountBalance(BigDecimal balance, BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new AccountNonSufficientFundException(String.format("Not enough found available, balance is less than %s", amount.toString()));
        }
    }
}
