package org.example.Deposit;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Deposit implements Serializable {
    private String bankName;
    private int value;
    private int percent;
    private long date;

    public Deposit() {
    }

    public Deposit(String bankName, int value, int percent, LocalDateTime date) {
        this.bankName = bankName;
        this.value = value;
        this.percent = percent;
        this.date = date.atZone(ZoneId.of("Europe/Kiev"))
                .toInstant().toEpochMilli();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDepositTime() {
        LocalDateTime dateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(dateTime);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "bankName='" + bankName + '\'' +
                ", value=" + value +
                ", percent=" + percent +
                ", date=" + getDepositTime() +
                '}';
    }

    public void replenish(int sum) {
        this.value += sum;
    }

}
