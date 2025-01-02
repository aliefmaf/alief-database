package com.jawaskrip;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("== Ledger System == ");

        do {
            System.out.print("Login or Register \n1. Login \n2. Register \n3. Exit \n->");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline character
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
        while(truth== true){
            System.out.printf("Account balance: %.2f\n", CDSR.balance);

            System.out.println("==Transactions==");
            System.out.println("1.Credit \n2.Debit\n3.Savings\n4.Quit\n");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                CDSR.credit();
                break;
                case 2:
                CDSR.debit();
                break;
                case 3:
                CDSR.Savings();
                break;
                case 4:
                truth=false;
                break;
                default:
                System.out.println("Invalid input \n");
                break;
            }

        }

        


        sc.close();  // Close the scanner object
    }

}