package com.ziomson.banking_system.controller;

import com.ziomson.banking_system.dto.AccountDto;
import com.ziomson.banking_system.entity.Account;
import com.ziomson.banking_system.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
    try {
        accountService.CreateAccount(accountDto);
        return ResponseEntity.ok(accountDto);
    } catch (Exception e) {
        throw new RuntimeException("Could not create account", e);
    }
}

@GetMapping("/{id}")
public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
    try {
        AccountDto accountDto = accountService.GetAccountById(id);
        return ResponseEntity.ok(accountDto);
    } catch (Exception e) {
        throw new RuntimeException("Could not get account with id" + id, e);
    }

}

@PutMapping("/{id}/deposit")
public ResponseEntity<AccountDto> despoit(@PathVariable Long id,
                                          @RequestBody Map<String, Double> request)
{
    Double amount = request.get("amount");
    AccountDto accountDto = accountService.Deposit(id, amount);
    return ResponseEntity.ok(accountDto);
}

    @PutMapping("/{id}/withdrawal")
    public ResponseEntity<AccountDto> withdrawal(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request)
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.Withdrawal(id, amount);
        return ResponseEntity.ok(accountDto);
    }

@GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
       List<AccountDto> accountDto= accountService.getAllAccounts();
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok(accountService.GetAccountById(id));
        } catch (Exception e) {
            throw new RuntimeException("Could not delete account with id" + id, e);
        }
    }
}
