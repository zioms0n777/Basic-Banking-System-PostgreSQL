package com.ziomson.banking_system.service;

import com.ziomson.banking_system.dto.AccountDto;
import com.ziomson.banking_system.entity.Account;

import java.util.List;

public interface IAccountService {

    AccountDto CreateAccount(AccountDto accountDto);
    AccountDto GetAccountById(Long id);
    AccountDto Deposit(Long id, double amount);
    AccountDto Withdrawal(Long id, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);

}
