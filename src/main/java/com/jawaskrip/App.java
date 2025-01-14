package com.jawaskrip;


import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // left empty
    }


    public static void main(String[] args) {

        new Thread(() -> Application.launch(App.class)).start();



        Scanner sc = new Scanner(System.in);
        int choice=0;

        System.out.println("== Ledger System == ");

        do {
            System.out.print("Login or Register \n1. Login \n2. Register \n3. Exit \n->");
            
            boolean validInput = false;
            while (!validInput) {
                String input = sc.nextLine(); // Read the input as a string
    
                // Modify the regex to allow only positive integers
                if (input.matches("-?\\d+")) {  // Accepts only digits (no negative or decimal points)
                    choice = Integer.parseInt(input);
                    validInput = true;
                } else {
                    System.out.println("Invalid input");
                }
            }
            // Login page
            if (choice == 1) {
                login.loginUser(sc);
            }
            // Register page
            else if (choice == 2) {
                login.registerUser(sc);
            }
            else if (choice == 3){
                System.exit(0);
                break; 
            }

        } while (choice != 1);
        
        
        boolean truth = true;
        while(truth){
            CDSR.balance= CDSR.getBalanceFromUsername(login.username);
            CDSR.savingBalance = CDSR.getSavingsBalanceFromUserID(CDSR.getUserIDFromUsername(login.username));
            CDSR.loanBalance = CDSR.getLoanBalanceFromLoanID(jawaSkripFinance.getLoanIDFromUserID(CDSR.getUserIDFromUsername(login.username)));

            System.out.printf("Account balance: %.2f\n", CDSR.balance);
            System.out.printf("Savings: %.2f\n", CDSR.savingBalance);
            System.out.printf("Loan: %.2f (%s)\n", CDSR.loanBalance, jawaSkripFinance.getLastPaymentDate(jawaSkripFinance.getLoanIDFromUserID(CDSR.getUserIDFromUsername(login.username))));    //add function to show last payment date

            System.out.println("==Transactions==");
            System.out.println("1.Credit \n2.Debit\n3.Savings\n4.Credit Loan\n5.Deposit Interest Predictor\n6.Spending Trends\n7.Saving growth\n8.Loan Repayment\n9.History\n10.Logout");

            boolean validInput = false;
            while (!validInput) {
                String input = sc.nextLine(); // Read the input as a string
    
                // Modify the regex to allow only positive integers
                if (input.matches("-?\\d+")) {  // Accepts only digits (no negative or decimal points)
                    choice = Integer.parseInt(input);
                    validInput = true;
                } else {
                    System.out.println("Invalid input");
                }
            }
            switch(choice){
                case 1:
                if (!CDSR.compareDates(jawaSkripFinance.getLoanIDFromUserID(CDSR.getUserIDFromUsername(login.username)))) break;
                CDSR.credit();
                break;
                case 2:
                if (!CDSR.compareDates(jawaSkripFinance.getLoanIDFromUserID(CDSR.getUserIDFromUsername(login.username)))) break;
                CDSR.debit();
                break;
                case 3:
                CDSR.Savings();
                break;
                case 4:
                jawaSkripFinance.credLoan();
                break;
                case 5:
                jawaSkripFinance.depositInterestPredictor();
                break;
                case 6:
                LedgerSystem.spendingTrends();
                break;
                case 7:
                LedgerSystem.savingGrowth();
                break;
                case 8:
                LedgerSystem.loanRepayment();
                break;
                case 9:
                CDSR.history();
                break;
                case 10:
                truth=false;
                break;
                default:
                System.out.println("Invalid input \n");
            }
        }
        sc.close();  // Close the scanner object
        System.out.println("\nThank you for using JawaSkrip Finance");
        System.exit(0);
    }
    
}


