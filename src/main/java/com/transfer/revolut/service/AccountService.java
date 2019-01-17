package com.transfer.revolut.service;


import com.transfer.revolut.entity.Account;
import com.transfer.revolut.repository.AccountRepository;
import com.transfer.revolut.response.TransferErrorResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public Account findByIban(String iban) {

        Account account = accountRepository.findByIban(iban);

        if(Objects.isNull(account)) {
            throw new NotFoundException(Response.status(Response.Status.NOT_FOUND).entity(new TransferErrorResponse("Account could not be found: "+ iban)).build());
        }
        return accountRepository.findByIban(iban);

    }
}
