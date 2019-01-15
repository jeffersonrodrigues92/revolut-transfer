package com.transfer.demo.rest.service;


import com.transfer.demo.rest.dto.AccountDTO;
import com.transfer.demo.rest.repository.AccountRepository;

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
