package org.example.Deposit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DepositDAO {
    ArrayList<Deposit> deposits;

    public DepositDAO() {
        deposits = new ArrayList<>();
    }

    public void addDeposit(Deposit deposit) {
        this.deposits.add(deposit);
    }

    public void deleteDeposit(Deposit deposit) {
        this.deposits.remove(deposit);
    }
    public void deleteDeposit(int index) {
        this.deposits.remove(index);
    }

    public ArrayList<Deposit> getAllDeposits() {
        return deposits;
    }

    public void saveDeposits() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("depositBD.dat"))) {
            oos.writeObject(this.deposits);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Deposit getDepositByIndex(int index) {
        try {
            return deposits.get(index);
        } catch (Exception e) {
            System.out.println("No such deposit");
            return new Deposit();
        }

    }

    public ArrayList<Deposit> sortByBankName() {
        ArrayList<Deposit> sorted = deposits;
        sorted.sort(new Comparator<Deposit>() {
            @Override
            public int compare(Deposit deposit1, Deposit deposit2) {
                Integer sum1 = 0;
                Integer sum2 = 0;
                for (Byte b : deposit1.getBankName().getBytes())
                    sum1 += b;
                for (Byte b : deposit2.getBankName().getBytes())
                    sum2 += b;
                return sum1.compareTo(sum2);
            }
        });

        return sorted;
    }
    public void loadDeposits(){
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("depositBD.dat"))) {
            deposits = (ArrayList<Deposit>) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
