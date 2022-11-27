package org.example.Deposit;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepositDAOTest {

    @Test
    void addDeposit() {
        DepositDAO dao = new DepositDAO();

        Deposit d1 = new Deposit("D1",1000,15, LocalDateTime.now());
        Deposit d2 = new Deposit("D2",1000,15, LocalDateTime.now());
        Deposit d3 = new Deposit("D3",1000,15, LocalDateTime.now());

        ArrayList<Deposit> test = new ArrayList<>();

        dao.addDeposit(d1);
        test.add(d1);
        assertEquals(test,dao.getAllDeposits());
        dao.addDeposit(d2);
        test.add(d2);
        assertEquals(test,dao.getAllDeposits());
        dao.addDeposit(d3);
        test.add(d3);
        assertEquals(test,dao.getAllDeposits());
    }

    @Test
    void deleteDeposit() {
        DepositDAO dao = new DepositDAO();

        Deposit d1 = new Deposit("D1",1000,15, LocalDateTime.now());
        Deposit d2 = new Deposit("D2",1000,15, LocalDateTime.now());
        Deposit d3 = new Deposit("D3",1000,15, LocalDateTime.now());

        ArrayList<Deposit> test = new ArrayList<>();

        dao.addDeposit(d1);
        dao.addDeposit(d2);
        dao.addDeposit(d3);
        test.add(d1);
        test.add(d2);
        dao.deleteDeposit(d3);
        assertEquals(test,dao.getAllDeposits());

    }

    @Test
    void testDeleteDeposit() {
        DepositDAO dao = new DepositDAO();

        Deposit d1 = new Deposit("D1",1000,15, LocalDateTime.now());
        Deposit d2 = new Deposit("D2",1000,15, LocalDateTime.now());
        Deposit d3 = new Deposit("D3",1000,15, LocalDateTime.now());

        ArrayList<Deposit> test = new ArrayList<>();

        dao.addDeposit(d1);
        dao.addDeposit(d2);
        dao.addDeposit(d3);
        test.add(d1);
        test.add(d2);
        dao.deleteDeposit(2);
        assertEquals(test,dao.getAllDeposits());
    }

    @Test
    void getAllDeposits() {
        DepositDAO dao = new DepositDAO();

        Deposit d1 = new Deposit("D1",1000,15, LocalDateTime.now());
        Deposit d2 = new Deposit("D2",1000,15, LocalDateTime.now());
        Deposit d3 = new Deposit("D3",1000,15, LocalDateTime.now());

        ArrayList<Deposit> test = new ArrayList<>();

        dao.addDeposit(d1);
        dao.addDeposit(d2);
        dao.addDeposit(d3);
        test.add(d1);
        test.add(d2);
        test.add(d3);

        assertEquals(test,dao.getAllDeposits());
    }
}