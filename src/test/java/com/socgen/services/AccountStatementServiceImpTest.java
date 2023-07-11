package com.socgen.services;

import com.socgen.domain.Account;
import com.socgen.domain.Operation;
import com.socgen.domain.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountStatementServiceImpTest {

    @Mock
    private Account account;
    private AccountStatementService accountStatementService;

    @BeforeEach
    public void before() {
        accountStatementService = new AccountStatementServiceImp();
    }

    @Test
    void shouldReturnAccountHistoric() {
        // Arrange
        var expectedOperation = Operation.builder()
                .id(1L)
                .balance(BigDecimal.TEN)
                .operationType(OperationType.Deposit)
                .amount(BigDecimal.TEN)
                .date(LocalDateTime.now())
                .build();

        when(account.getOperations()).thenReturn(Collections.singletonList(expectedOperation));

        // Act
        var operationsHistoric = accountStatementService.getHistoric(account);

        // Assert
        verify(account).getOperations();

        assertNotNull(operationsHistoric);
        assertEquals(1, operationsHistoric.size());
        assertEquals(expectedOperation, operationsHistoric.get(0));
    }
}