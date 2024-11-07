package com.ziomson.banking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;


}
