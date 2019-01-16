package com.transfer.revolut.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transfer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="transaction_id")
    private String transactionId;
    @OneToOne
    @NotNull(message = "bankAccountOrigin cannot be null")
    private Account bankAccountOrigin;
    @OneToOne
    @NotNull(message = "bankAccountDestination cannot be null")
    private Account bankAccountDestination;
    @NotNull(message = "amount cannot be null")
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getBankAccountOrigin() {
        return bankAccountOrigin;
    }

    public void setBankAccountOrigin(Account bankAccountOrigin) {
        this.bankAccountOrigin = bankAccountOrigin;
    }

    public Account getBankAccountDestination() {
        return bankAccountDestination;
    }

    public void setBankAccountDestination(Account bankAccountDestination) {
        this.bankAccountDestination = bankAccountDestination;
    }
}
