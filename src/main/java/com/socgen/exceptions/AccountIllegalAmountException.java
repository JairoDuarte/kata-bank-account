package com.socgen.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountIllegalAmountException extends IllegalArgumentException {
    public AccountIllegalAmountException(String message) {
        super(message);
    }
}
