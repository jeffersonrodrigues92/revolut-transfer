package com.transfer.revolut.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountDTO {

    @NotNull(message = "iban cannot be null")
    private String iban;
    @NotNull(message = "ibic cannot be empty")
    private String bic;
    @NotNull(message = "email cannot be empty")
    private String email;

    private Double bankBalance;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
