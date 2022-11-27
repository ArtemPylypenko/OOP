
package org.example;


import org.example.Deposit.Deposit;
import org.example.Deposit.DepositDAO;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String availableDeposits = "-1 Privat 15%" + "\n" +
                "-2 Privat 30%" + "\n" +
                "-3 Oshchad 17%" + "\n" +
                "-4 Oshchad 22%" + "\n" +
                "-5 Mono 15%";
        String menu = "\nChoose operation: \n" +
                "1 - see available deposits\n" +
                "2 - show my deposits\n" +
                "3 - make a deposit\n" +
                "4 - delete deposit (by not-sorted index)\n" +
                "5 - show my deposits sorted by bankName\n" +
                "6 - save\n" +
                "7 - exit";

        Scanner scanner = new Scanner(System.in);
        DepositDAO dao = new DepositDAO();
        dao.loadDeposits();
        boolean isExit = false;
        while (!isExit) {
            System.out.println(menu);
            String operation = scanner.nextLine();
            if (operation.length() > 1) {
                System.out.println("Unknown!");
            } else {
                switch (operation) {
                    case "1": {
                        System.out.println(availableDeposits);
                        break;
                    }
                    case "2": {
                        for (Deposit d : dao.getAllDeposits()) {
                            System.out.println(d.toString());
                        }
                        break;
                    }
                    case "3": {
                        System.out.println(availableDeposits);
                        System.out.println("Chose number of deposit: ");
                        try {
                            int depositToAdd = scanner.nextInt();
                            System.out.println("Enter value: ");
                            int value = scanner.nextInt();
                            switch (depositToAdd) {
                                case 1: {
                                    dao.addDeposit(new Deposit("Privat", value, 15, LocalDateTime.now()));
                                    break;
                                }
                                case 2: {
                                    dao.addDeposit(new Deposit("Privat", value, 30, LocalDateTime.now()));
                                    break;
                                }
                                case 3: {
                                    dao.addDeposit(new Deposit("Oshchad", value, 17, LocalDateTime.now()));
                                    break;
                                }
                                case 4: {
                                    dao.addDeposit(new Deposit("Oshchad", value, 22, LocalDateTime.now()));
                                    break;
                                }
                                case 5: {
                                    dao.addDeposit(new Deposit("Mono", value, 15, LocalDateTime.now()));
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }


                        } catch (Exception e) {
                            System.out.println("Incorrect input!");
                        }
                        break;
                    }

                    case "4": {
                        System.out.println("Enter deposit index to delete");

                        try {
                            int toDelete = scanner.nextInt();
                            dao.deleteDeposit(toDelete);
                        } catch (Exception e) {
                            System.out.println("Incorrect index");
                            break;
                        }
                        break;
                    }
                    case "5": {
                        for (Deposit d : dao.sortByBankName()) {
                            System.out.println(d.toString());
                        }
                        break;
                    }
                    case "6": {
                        dao.saveDeposits();
                        dao.loadDeposits();
                        break;
                    }
                    case "7": {
                        isExit = true;
                        break;
                    }
                }
            }
        }

    }
}