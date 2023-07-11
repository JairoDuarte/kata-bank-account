package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.domain.Operation;

import java.util.List;

public interface AccountStatementService {
    public List<Operation> getHistoric(Account account);
}
