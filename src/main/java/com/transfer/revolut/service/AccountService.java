package com.transfer.revolut.service;


import com.transfer.revolut.repository.AccountRepository;
import com.transfer.revolut.dto.AccountDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountDTO findByIban(String iban) {
        return accountRepository.findByIban(iban);
    }
}
