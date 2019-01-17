package com.transfer.revolut.repository;

import com.transfer.revolut.entity.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

/**
 * Jefferson Rodrigues
 */
@ApplicationScoped
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Account findByIban(String iban){
        Account account = null;
        try{
           account = entityManager.find(Account.class, iban);
        }catch (NoResultException e){
            e.printStackTrace();
        }
        return account;
    }

    @Transactional
    public void merge(Account account) {
        entityManager.merge(account);
        entityManager.flush();
    }
}
