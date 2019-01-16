package com.transfer.revolut.service;


import com.transfer.revolut.entity.Account;
import com.transfer.revolut.repository.AccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.Objects;

@ApplicationScoped
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public Account findByIban(String iban) {

        Account account = accountRepository.findByIban(iban);

        if(Objects.isNull(account)) {
            throw new NotFoundException("Account could not be found: "+ iban);
        }
        return accountRepository.findByIban(iban);

    }
}
