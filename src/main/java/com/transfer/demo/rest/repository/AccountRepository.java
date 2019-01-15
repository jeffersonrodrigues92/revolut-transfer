package com.transfer.demo.rest.repository;

import com.transfer.demo.rest.dto.AccountDTO;
import com.transfer.demo.rest.dto.TransferDTO;
import com.transfer.demo.rest.entity.AccountEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@ApplicationScoped
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;


    public AccountDTO findByIban(String iban){

        AccountDTO accountDTO = null;
        AccountEntity accountEntity = em.find(AccountEntity.class, iban);

        if(Objects.nonNull(accountDTO)){

            accountDTO = new AccountDTO();

            accountDTO.setIban(accountEntity.getIban());
            accountDTO.setBic(accountEntity.getBic());
            accountDTO.setBankBalance(accountEntity.getBankBalance());
            accountDTO.setEmail(accountEntity.getEmail());
        }

        return accountDTO;
    }

}
