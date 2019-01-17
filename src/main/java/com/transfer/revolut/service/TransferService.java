package com.transfer.revolut.service;

import java.util.Objects;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.transfer.revolut.entity.Account;
import com.transfer.revolut.entity.Transfer;
import com.transfer.revolut.repository.AccountRepository;
import com.transfer.revolut.repository.TransferRepository;
import com.transfer.revolut.response.TransferErrorResponse;

@RequestScoped
public class TransferService {

    @Inject
    private TransferRepository transferRepository;

    @Inject
    private AccountRepository accountRepository;

    public Transfer findByTransactionId(String transactionId){
        Transfer transfer = transferRepository.findByTransactionId(transactionId);
        if(Objects.isNull(transfer)) {
            throw new NotFoundException(Response.status(Response.Status.NOT_FOUND).entity(new TransferErrorResponse("TransactionId could not be found: "+ transactionId)).build());
        }
        return transfer;
    }

    public String transfer(Transfer transfer){

        validateAccount(transfer);
        validatetransfer(transfer);

        UUID uuid = UUID.randomUUID();
        transfer.setTransactionId(uuid.toString());

        confirmTransfer(transfer);

        return transfer.getTransactionId();
    }

    public void validateAccount(Transfer transfer){

        Account accountOrigin = accountRepository.findByIban(transfer.getBankAccountOrigin().getIban());
        if(Objects.isNull(accountOrigin)) {
            throw new NotFoundException(Response.status(Response.Status.NOT_FOUND).entity(new TransferErrorResponse("Account could not be found: "+transfer.getBankAccountOrigin().getIban())).build());
        }

        Account accountDestination = accountRepository.findByIban(transfer.getBankAccountDestination().getIban());
        if(Objects.isNull(accountDestination)) {
            throw new NotFoundException(Response.status(Response.Status.NOT_FOUND).entity(new TransferErrorResponse("Account could not be found: "+transfer.getBankAccountDestination().getIban())).build());
        }

        transfer.setBankAccountOrigin(accountOrigin);
        transfer.setBankAccountDestination(accountDestination);
   }


    public void validatetransfer(Transfer transfer){

        if(transfer.getBankAccountOrigin().getBankBalance() < transfer.getAmount()){
            throw new ForbiddenException(Response.status(Response.Status.FORBIDDEN).entity(new TransferErrorResponse("You do not have enough balance")).build());
        }
        transfer.getBankAccountOrigin().setBankBalance(transfer.getBankAccountOrigin().getBankBalance() - transfer.getAmount());
        transfer.getBankAccountDestination().setBankBalance(transfer.getBankAccountDestination().getBankBalance() + transfer.getAmount());
    }

    private void confirmTransfer(Transfer transfer) {
        accountRepository.merge(transfer.getBankAccountOrigin());
        accountRepository.merge(transfer.getBankAccountDestination());
        transferRepository.save(transfer);
    }
}
