package com.cuongnt;

import com.cuongnt.utils.CollectionAllowDuplicatedKey;
import com.cuongnt.utils.Utils;
import model.Patient;

import java.util.*;
import java.util.regex.Pattern;

public class PatientManager {
    public static Scanner scanner = new Scanner(System.in);
    private static final int PATIENT_TOOK_AN_EXAM = 1;
    private LinkedList<Patient> patientList;
    private Stack<Patient> reviewedPatientList;
    private CollectionAllowDuplicatedKey patientSearchList;
    private CollectionAllowDuplicatedKey reviewPatientSearchList;
    private PatientDao patientDao;

    public Stack<Patient> getReviewedPatientList() {
        return reviewedPatientList;
    }

    public CollectionAllowDuplicatedKey getPatientSearchList() {
        if (null == patientSearchList) {
            patientSearchList = new CollectionAllowDuplicatedKey();
            for (Patient patient : getPatientList()) {
                patientSearchList.putValue(patient.getName(), patient);
            }
        }
        return patientSearchList;
    }

    public CollectionAllowDuplicatedKey getReviewPatientSearchList() {
        if (null == reviewPatientSearchList) {
            reviewPatientSearchList = new CollectionAllowDuplicatedKey();
            for (Patient patient : getReviewedPatientList()) {
                reviewPatientSearchList.putValue(patient.getName(), patient);
            }
        }
        return reviewPatientSearchList;
    }

    public PatientManager() {
        patientDao = new PatientDao();
        patientList = patientDao.readToLinkedList();
        reviewedPatientList = patientDao.readToStack();
    }

    /*
     * Add patient to patientList
     * */

    public void addPatient() {
        int id = patientList.size() > 0 ? patientList.size() + 1 : 1;
        System.out.println("patient id = " + id);
//        int id = inputId();
        String name = inputPatientName();
        int age = inputPatientAge();
        String address = inputPatientAddress();
        String telephone = inputPatientTelephone();
        int priority = inputPatientPriority();
        int tookAnExam = patientIsTakeAnExam();
        Patient patient = new Patient(id, name, age, address, telephone, priority, tookAnExam);
        patientList.add(patient);
        Collections.sort(patientList, new SortPatientByPriority());
        if (tookAnExam == PATIENT_TOOK_AN_EXAM) {
            patientDao.write(patientList, false);
        }
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    /*
     * show list patient
     * */
    public void show(boolean isReviewList) {
        List<Patient> targetList = isReviewList ? getReviewedPatientList() : getPatientList();
        show(targetList);
    }

    public void show(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.format("%5d  | ", patient.getId());
            System.out.format("%20s | ", patient.getName());
            System.out.format("%5d  | ", patient.getAge());
            System.out.format("%20s | ", patient.getAddress());
            System.out.format("%10s | ", patient.getTelephone());
            System.out.format("%d   | ", patient.getPriority());
            System.out.format("%s   | ", patient.isExaminated());
            System.out.print("\n");
        }
    }

    /*
     * sort by priority
     * */
    public void sortByPriority() {
        Collections.sort(patientList, new SortPatientByPriority());
    }

    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    /*
     * input patient name
     * */
    private String inputPatientName() {
        System.out.println("Input patient name: ");
        return scanner.nextLine();
    }

    /*
     * input patient age
     * */
    private int inputPatientAge() {
        System.out.print("Input patient age: ");
        int age = 0;
        do {
            try {
                age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 || age > 200) {
                    System.out.println("Invalid age of patient");
                    System.out.print("Input patient age: ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid age of patient");
                System.out.print("Input patient age: ");
            }
        } while (age < 0 || age > 200);
        return age;
    }

    /*
     * input student address
     * */

    private String inputPatientAddress() {
        System.out.print("Input patient address: ");
        return scanner.nextLine();
    }

    private String inputPatientTelephone() {
        System.out.print("Input patient telephone: ");
        String phoneNumber = scanner.nextLine();

        boolean isPhoneNumberValid = Utils.validatePhoneNumber(phoneNumber);

        if (!isPhoneNumberValid) {
            System.out.println("Phone number is invalid");
            inputPatientTelephone();
        }

        return phoneNumber;
    }

    private int inputPatientPriority() {
        System.out.print("Input patient priority: ");
        int priority = 0;
        do {
            try {
                priority = Integer.parseInt((scanner.nextLine()));
                if (priority < 0 || priority > 3) {
                    System.out.println("Invalid input patient priority. Range of patient priority from 0 to 3.");
                    System.out.print("Input patient priority: ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input patient priority. Range of patient priority from 0 to 3.");
                System.out.print("Input patient priority: ");
            }
        } while (priority < 0 || priority > 3);
        return priority;
    }

    public int patientIsTakeAnExam() {
        System.out.print("Patient took an exam: ");
        int patientTookExam = -1;
        do {
            try {
                patientTookExam = Integer.parseInt((scanner.nextLine()));
                if (patientTookExam != 0 && patientTookExam != 1) {
                    System.out.println("Invalid input patient is taken exam. Valid value is 1 or 0");
                    System.out.print("Patient took an exam: ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input patient is taken exam. Valid value is 1 or 0");
                System.out.print("Patient took an exam: ");
            }
        } while (patientTookExam != 0 && patientTookExam != 1);
        return patientTookExam;
    }

    /*
     * getter and setter
     * */

    public LinkedList<Patient> getPatientList() {
        return patientList;
    }

    public void filterPatientsList(String condition, String patientId) {
        int patientIntId = Integer.parseInt(patientId);
        LinkedList<Patient> filterPatients = new LinkedList<>();
        switch (condition) {
            case "<":
                for (Patient patient : patientList) {
                    if (patient.getId() < patientIntId) {
                        filterPatients.add(patient);
                    }
                }
                break;
            case ">":
                for (Patient patient : patientList) {
                    if (patient.getId() > patientIntId) {
                        filterPatients.add(patient);
                    }
                }
                break;
            case "=":
                for (Patient patient : patientList) {
                    if (patient.getId() == patientIntId) {
                        filterPatients.add(patient);
                    }
                }
                break;
            default:
                System.out.println("Unhandled value!");
                break;
        }
        Stack<Patient> currentReviewList = patientDao.readToStack();

        while (!filterPatients.isEmpty()) {
            Patient patient = filterPatients.pop();
            if (!currentReviewList.contains(patient)) {
                currentReviewList.add(patient);
            }
        }

        currentReviewList.removeAll(filterPatients);
        currentReviewList.addAll(filterPatients);

        Collections.sort(currentReviewList, new SortPatientByPriority());
        patientList.removeAll(currentReviewList);

        patientDao.write(patientList, false);
        patientDao.write(currentReviewList, true);

        patientList = patientDao.readToLinkedList();
        reviewedPatientList = patientDao.readToStack();
    }
}
