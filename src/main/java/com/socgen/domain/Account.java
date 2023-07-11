package com.socgen.domain;

import com.socgen.helpers.AccountValidator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {

    private final Long id;

    private BigDecimal balance;

    private List<Operation> operations;

    public Account(Long id) {
        this.id = id;
        balance = BigDecimal.ZERO;
        operations = new LinkedList<>();
    }

    public void deposit(BigDecimal amount) {
        AccountValidator.validateOperationAmount(amount);

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        AccountValidator.validateOperationAmount(amount);
        AccountValidator.validateAccountBalance(balance, amount);

        balance = balance.subtract(amount);
    }

    public void addOperation(Operation operation){
        operations.add(operation);
    }
}
