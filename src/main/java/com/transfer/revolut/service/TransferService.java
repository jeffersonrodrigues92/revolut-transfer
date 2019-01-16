package com.transfer.revolut.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import com.transfer.revolut.entity.Account;
import com.transfer.revolut.entity.Transfer;
import com.transfer.revolut.repository.AccountRepository;
import com.transfer.revolut.repository.TransferRepository;

@RequestScoped
public class TransferService {

    @Inject
    private TransferRepository transferRepository;

    @Inject
    private AccountRepository accountRepository;

    public List<Transfer> findByTransactionId(String transactionId){
        List<Transfer> transfers = transferRepository.findByTransactionId(transactionId);
        if(transfers.isEmpty()) {
            throw new NotFoundException("TransactionId could not be found: "+ transactionId);
        }
        return transfers;
    }

    public String transfer(Transfer transfer){

        validateAccount(transfer);
        validatetransfer(transfer);

        UUID uuid = UUID.randomUUID();
        transfer.setTransactionId(uuid.toString());

        accountRepository.merge(transfer.getBankAccountOrigin());
        accountRepository.merge(transfer.getBankAccountDestination());
        transferRepository.save(transfer);

        return transfer.getTransactionId();
    }

    public void validateAccount(Transfer transfer){

        Account accountOrigin = accountRepository.findByIban(transfer.getBankAccountOrigin().getIban());
        if(Objects.isNull(accountOrigin)) {
            throw new NotFoundException("Account could not be found: "+transfer.getBankAccountOrigin().getIban());
        }

        Account accountDestination = accountRepository.findByIban(transfer.getBankAccountDestination().getIban());
        if(Objects.isNull(accountDestination)) {
            throw new NotFoundException("Account could not be found: "+transfer.getBankAccountDestination().getIban());
        }

        transfer.setBankAccountOrigin(accountOrigin);
        transfer.setBankAccountDestination(accountDestination);
   }

    public void validatetransfer(Transfer transfer){

        if(transfer.getBankAccountOrigin().getBankBalance() < transfer.getAmount()){
            throw new ForbiddenException("You do not have enough balance");
        }
        transfer.getBankAccountOrigin().setBankBalance(transfer.getBankAccountOrigin().getBankBalance() - transfer.getAmount());
        transfer.getBankAccountDestination().setBankBalance(transfer.getBankAccountDestination().getBankBalance() + transfer.getAmount());
    }
}
