package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.domain.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImpTest {

    private AccountService accountService;

    @BeforeEach
    public void before() {
        accountService = new AccountServiceImp();
    }

    @Test
    void shouldDepositAmount() {
        // Arrange
        Account account = new Account(1L);

        // Act
        accountService.deposit(account, BigDecimal.TEN);

        // Assert
        assertEquals(BigDecimal.TEN, account.getBalance());
        assertEquals(1, account.getOperations().size());
        assertEquals(OperationType.Deposit, account.getOperations().get(0).getOperationType());
        assertEquals(BigDecimal.TEN, account.getOperations().get(0).getAmount());
        assertEquals(account.getBalance(), account.getOperations().get(0).getBalance());
    }

    @Test
    void shouldWithdrawAmount() {
        // Arrange
        Account account = new Account(1L);
        account.deposit(BigDecimal.valueOf(100));
        var expectedAmount = BigDecimal.valueOf(100).subtract(BigDecimal.TEN);

        // Act
        accountService.withdraw(account, BigDecimal.TEN);

        // Assert
        assertEquals(expectedAmount, account.getBalance());
        assertEquals(1, account.getOperations().size());
        assertEquals(OperationType.Withdraw, account.getOperations().get(0).getOperationType());
        assertEquals(BigDecimal.TEN, account.getOperations().get(0).getAmount());
        assertEquals(account.getBalance(), account.getOperations().get(0).getBalance());
    }
}