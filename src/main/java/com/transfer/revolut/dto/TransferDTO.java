package com.transfer.revolut.dto;

import java.io.Serializable;

public class TransferDTO implements Serializable {


    private AccountDTO accountOrigin;
    private AccountDTO accountDestionation;
    private Double amount;

    public AccountDTO getAccountOrigin() {
        return accountOrigin;
    }

    public void setAccountOrigin(AccountDTO accountOrigin) {
        this.accountOrigin = accountOrigin;
    }

    public AccountDTO getAccountDestionation() {
        return accountDestionation;
    }

    public void setAccountDestionation(AccountDTO accountDestionation) {
        this.accountDestionation = accountDestionation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
