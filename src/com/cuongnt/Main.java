package com.cuongnt;

import java.util.Scanner;

public class Main {
    public static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        PatientManager patientManager = new PatientManager();
        int patientId;

        showMenu();

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    patientManager.addPatient();
                    break;
                case "2":
                    break;
                case "3":
                    patientManager.sortByPriority();
                    break;
                case "4":
                    patientManager.show();
                    break;
                case "0":
                    System.out.println("Exit system!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid. Please choose item in the menu:");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("\n-----------menu------------");
        System.out.println("1. Add patient.");
        System.out.println("2. Delete patient by id.");
        System.out.println("3. Sort patient by priority");
        System.out.println("4. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
