package com.socgen.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountNonSufficientFundException extends RuntimeException {
    public AccountNonSufficientFundException(String message) {
        super(message);
    }
}
