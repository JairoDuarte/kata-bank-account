package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.domain.Operation;

import java.util.List;

public class AccountStatementServiceImp implements AccountStatementService {
    @Override
    public List<Operation> getHistoric(Account account) {
        return account.getOperations();
    }
}
