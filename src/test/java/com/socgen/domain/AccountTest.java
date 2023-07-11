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
        account = new Account(1L);
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
    void shouldThrowAccountIllegalAmountExceptionIfDepositAmountIsLessThanZero() {
        var exception = assertThrows(AccountIllegalAmountException.class, () -> account.deposit(BigDecimal.valueOf(-10)));

        assertEquals("amount -10 is less or equal to 0, it must be more than 0", exception.getMessage());
    }

    @Test
    void shouldThrowAccountIllegalAmountExceptionIfDepositAmountIsEqualToZero() {
        var exception =  assertThrows(AccountIllegalAmountException.class, () -> account.deposit(BigDecimal.ZERO));

        assertEquals("amount 0 is less or equal to 0, it must be more than 0", exception.getMessage());
    }

    @Test
    void shouldThrowAccountIllegalAmountExceptionIfWithdrawAmountIsLessOrEqualToZero() {
        assertThrows(AccountIllegalAmountException.class, () -> account.withdraw(BigDecimal.valueOf(-10)));

        assertThrows(AccountIllegalAmountException.class, () -> account.withdraw(BigDecimal.ZERO));
    }

    @Test
    void shouldThrowAccountNonSufficientFundExceptionIfBalanceIsLessThanWithdrawAmount() {
       var exception = assertThrows(AccountNonSufficientFundException.class, () -> account.withdraw(BigDecimal.valueOf(10)));

       assertEquals("Not enough found available, balance is less than 10", exception.getMessage());
    }

}