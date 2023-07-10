package com.socgen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@ToString
public class Account {
    private final Long id;

    private BigDecimal balance;

    public void deposit(BigDecimal amount) {
        AccountValidator.validateOperationAmount(amount);

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        AccountValidator.validateOperationAmount(amount);
        AccountValidator.validateAccountBalance(balance, amount);

        balance = balance.subtract(amount);
    }
}
