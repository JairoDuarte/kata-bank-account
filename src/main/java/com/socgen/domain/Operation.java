package com.socgen.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@EqualsAndHashCode
public class Operation {
    private OperationType operationType;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;
}
