package com.transfer.revolut.repository;

import com.transfer.revolut.dto.AccountDTO;
import com.transfer.revolut.entity.AccountEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Objects;

@ApplicationScoped
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public AccountDTO findByIban(String iban){

        AccountDTO accountDTO = null;
        AccountEntity accountEntity = em.find(AccountEntity.class, iban);

        if(Objects.nonNull(accountEntity)){

            accountDTO = new AccountDTO();

            accountDTO.setIban(accountEntity.getIban());
            accountDTO.setBic(accountEntity.getBic());
            accountDTO.setBankBalance(accountEntity.getBankBalance());
            accountDTO.setEmail(accountEntity.getEmail());
        }

        return accountDTO;
    }
}
