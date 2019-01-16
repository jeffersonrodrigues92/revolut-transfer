package com.transfer.revolut.repository;

import com.transfer.revolut.entity.Transfer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
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

    public List<Transfer> findByTransactionId(String transactionId){

        TypedQuery<Transfer> nativeQuery =
                entityManager.createQuery("from Transfer t where t.transactionId = :transactionId",Transfer.class)
                        .setParameter("transactionId", transactionId);

        List<Transfer> transfersList= nativeQuery.getResultList();
        List<Transfer> transfers = new ArrayList<>();

        for (Transfer transferResponse: transfersList) {
            Transfer transfer = new Transfer();
            transfer.setId(transferResponse.getId());
            transfer.setTransactionId(transferResponse.getTransactionId());
            transfer.setBankAccountOrigin(transferResponse.getBankAccountOrigin());
            transfer.setBankAccountDestination(transferResponse.getBankAccountDestination());
            transfer.setAmount(transferResponse.getAmount());
            transfers.add(transfer);
        }
        return transfers;
    }

    @Transactional
    public void save(Transfer transfer) {
        entityManager.persist(transfer);
        entityManager.flush();
    }
}
