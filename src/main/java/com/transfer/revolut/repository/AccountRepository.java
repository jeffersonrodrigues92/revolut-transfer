package com.transfer.revolut.repository;

import com.transfer.revolut.entity.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 * Jefferson Rodrigues
 */
@ApplicationScoped
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Account findByIban(String iban){
        return entityManager.find(Account.class, iban);
    }

    @Transactional
    public void merge(Account account) {
        entityManager.merge(account);
        entityManager.flush();
    }
}
