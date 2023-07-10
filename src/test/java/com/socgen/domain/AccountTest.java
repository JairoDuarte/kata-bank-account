package com.socgen.domain;

import com.socgen.exceptions.AccountIllegalAmountException;
import com.socgen.exceptions.AccountNonSufficientFundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    public void before() {
        account = new Account(1L, BigDecimal.ZERO);
    }

    @Test
    void shouldAddDepositAmountInBalance() {
        // Arrange
        var expectedValue = BigDecimal.valueOf(100);

        // act
        account.deposit(expectedValue);

        // Assert
        assertEquals(expectedValue, account.getBalance());
    }

    @Test
    void shouldWithdrawAmountFromBalance() {
        // Arrange
        account.deposit(BigDecimal.valueOf(200));
        var expectedValue = BigDecimal.valueOf(100);

        // act
        account.withdraw(expectedValue);

        // Assert
        assertEquals(expectedValue, account.getBalance());
    }

    @Test
    void shouldThrowAccountIllegalAmountExceptionIfDepositAmountIsLessOrEqualToZero() {
        assertThrows(AccountIllegalAmountException.class, () -> account.deposit(BigDecimal.valueOf(-10)));

        assertThrows(AccountIllegalAmountException.class, () -> account.deposit(BigDecimal.ZERO));
    }

    @Test
    void shouldThrowAccountIllegalAmountExceptionIfWithdrawAmountIsLessOrEqualToZero() {
        assertThrows(AccountIllegalAmountException.class, () -> account.withdraw(BigDecimal.valueOf(-10)));

        assertThrows(AccountIllegalAmountException.class, () -> account.withdraw(BigDecimal.ZERO));
    }

    @Test
    void shouldThrowAccountNonSufficientFundExceptionIfBalanceIsLessThanWithdrawAmount() {
        assertThrows(AccountNonSufficientFundException.class, () -> account.withdraw(BigDecimal.valueOf(10)));
    }

}