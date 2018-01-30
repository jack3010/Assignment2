package com.cuongnt;

import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static PatientManager patientManager;
    private static boolean isReviewListShowing;

    public static void main(String[] args) {
        String choose;
        boolean exit = false;
        patientManager = new PatientManager();

        showMainMenu();

        Boolean backToReviewMenu = null;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    patientManager.addPatient();
                    break;
                case "2":
                    break;
                case "3":
                    if (isReviewListShowing) {
                        showMainMenu();
                    } else {
                        patientManager.sortByPriority();
                    }
                    break;
                case "4":
                    patientManager.show(false);
                    break;
                case "5":
                    patientManager.show(false);
                    showReviewMenu();
                    String reviewOption;
                    reviewOption = scanner.nextLine();
                    switch (reviewOption) {
                        case "1":
                            String condition;
                            String patientId;
                            System.out.println("Input filter condition (must to be '<' or '>' or '='): ");
                            do {
                                condition = scanner.nextLine();
                            } while (!condition.equals("<") && !condition.equals(">") && !condition.equals("="));

                            System.out.println("Input patient's id: ");
                            do {
                                patientId = scanner.nextLine();
                            } while (!Stream.of(patientId)
                                    .filter(s -> s != null && !s.isEmpty()) //Lambda
                                    .filter(Pattern.compile("\\D").asPredicate().negate())
                                    .mapToLong(Long::valueOf)
                                    .boxed()
                                    .findAny()
                                    .isPresent());
                            System.out.println("Please wait...");
                            patientManager.filterPatientsList(condition, patientId);
                            patientManager.show(false);
                            System.out.println("==================================================================================================");
                            patientManager.show(true);
                            break;
                        case "2":
                            backToReviewMenu = searchPatientsByName(true);
                            break;
                        case "3":
                            backToReviewMenu = false;
                            break;
                        default:
                            showReviewMenu();
                            break;
                    }
                    break;
                case "6":
                    patientManager.show(true);
                    break;
                case "7":
                    backToReviewMenu = searchPatientsByName(false);
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
            if (null != backToReviewMenu && !backToReviewMenu) {
                showMainMenu();
                backToReviewMenu = null;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n-----------Main Menu------------");
        System.out.println("1. Add patient.");
        System.out.println("2. Delete patient by id.");
        System.out.println("3. Sort patient by priority");
        System.out.println("4. Show patient.");
        System.out.println("5. Review list of patients.");
        System.out.println("6. Show reviewed list of patients.");
        System.out.println("7. Search patient(s) by name.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
        isReviewListShowing = false;
    }

    private static void showReviewMenu() {
        System.out.println("\n-----------Review Menu------------");
        System.out.println("1. Input patient condition");
        System.out.println("2. Search patient(s) by name.");
        System.out.println("3. Back to main menu");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
        isReviewListShowing = true;
    }

    private static Boolean searchPatientsByName(boolean isReviewList) {
        System.out.print("Input search content or 'null' to back: ");
        String searchContent;
        do {
            searchContent = scanner.nextLine();
        } while (null == searchContent || searchContent.isEmpty());

        searchContent = searchContent.toLowerCase();
        if (searchContent.equals("null")) {
            if (isReviewList) {
                showReviewMenu();
                return true;
            }
        } else {
            List<Patient> searchResultPatients = new ArrayList<>();
            List<Patient> listOfPatients = isReviewList ? patientManager.getReviewedPatientList() : patientManager.getPatientList();
            for (Patient patient : listOfPatients) {
                if (patient.getName().toLowerCase().contains(searchContent)) {
                    searchResultPatients.add(patient);
                }
            }
            patientManager.show(searchResultPatients);
            if (isReviewList) {
                showReviewMenu();
                return true;
            }
        }
        return false;
    }
}
