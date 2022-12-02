package org.example.deposits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deposit implements Comparable<Deposit>{
    String name;
    String country;
    DepositType type;
    String depositor;
    int accountId;
    int amountOnDeposit;
    int profitability;
    int timeConstraints;

    public Deposit() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(DepositType type) {
        this.type = type;
    }
    public void setType(String type) {
        this.type = DepositType.valueOf(type);
    }


    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = Integer.parseInt(accountId);
    }

    public void setAmountOnDeposit(int amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }
    public void setAmountOnDeposit(String amountOnDeposit) {
        this.amountOnDeposit = Integer.parseInt(amountOnDeposit);
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }
    public void setProfitability(String profitability) {
        this.profitability = Integer.parseInt(profitability);
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    public void setTimeConstraints(String timeConstraints) {
        this.timeConstraints = Integer.parseInt(timeConstraints);
    }

    public Deposit(String name, String country, DepositType type, String depositor,
                   int accountId, int amountOnDeposit, int profitability, int timeConstraints) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
    }
    public Deposit(String name, String country, String type, String depositor,
                   String accountId, String amountOnDeposit, String profitability, String timeConstraints) {
        this.name = name;
        this.country = country;
        this.type = DepositType.valueOf(type);
        this.depositor = depositor;
        this.accountId = Integer.parseInt(accountId);
        this.amountOnDeposit = Integer.parseInt(amountOnDeposit);
        this.profitability = Integer.parseInt(profitability);
        this.timeConstraints = Integer.parseInt(timeConstraints);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public DepositType getType() {
        return type;
    }

    public String getDepositor() {
        return depositor;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public int getProfitability() {
        return profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", depositor='" + depositor + '\'' +
                ", accountId=" + accountId +
                ", amountOnDeposit=" + amountOnDeposit +
                ", profitability=" + profitability +
                ", timeConstraints=" + timeConstraints +
                '}';
    }

    @Override
    public int compareTo(Deposit deposit) {
        return name.compareTo(deposit.getName());
    }
}
