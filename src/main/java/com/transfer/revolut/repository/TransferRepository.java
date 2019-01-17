package com.transfer.revolut.repository;

import com.transfer.revolut.entity.Transfer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Jefferson Rodrigues
 */
@ApplicationScoped
public class TransferRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Transfer findByTransactionId(String transactionId) {

        Transfer transfer = null;

        try {
            TypedQuery<Transfer> nativeQuery =
                    entityManager.createQuery("from Transfer t where t.transactionId = :transactionId", Transfer.class)
                            .setParameter("transactionId", transactionId);
            transfer = nativeQuery.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return transfer;
    }

    @Transactional
    public void save(Transfer transfer) {
        entityManager.persist(transfer);
        entityManager.flush();
    }
}
