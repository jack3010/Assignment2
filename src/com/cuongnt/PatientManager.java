package com.cuongnt;

import model.Patient;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Patient> patientList;
    private PatientDao patientDao;

    public PatientManager() {
        patientDao = new PatientDao();
        patientList = patientDao.read();
    }

    /*
    * Add patient to patientList
    * */

    public void addPatient() {
//        int id = patientList.size() > 0 ? patientList.size() + 1 : 1;
//        System.out.println("patient id = " + id);
        int id = inputId();
        String name = inputPatientName();
        int age = inputPatientAge();
        String address = inputPatientAddress();
        String telephone = inputPatientTelephone();
        int priority = inputPatientPriority();
        int tookAnExam = patientIsTakeAnExam();
        Patient patient = new Patient(id, name, age, address, telephone, priority, tookAnExam);
        patientList.add(patient);
        patientDao.write(patientList);
    }
    /*
    * show list patient
    * */
    public void show() {
        for (Patient patient : patientList) {
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
        while (true) {
            try {
                int age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 && age > 200) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid age of patient");
            }
        }
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
        return scanner.nextLine();
    }

    private int inputPatientPriority() {
        System.out.print("Input patient priority: ");
        while (true) {
            try {
                int priority = Integer.parseInt((scanner.nextLine()));
                if (priority < 0 && priority > 3) {
                    throw new NumberFormatException();
                }
                return priority;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input patient priority. Range of patient priority from 0 to 3. ");
            }
        }
    }

    public int patientIsTakeAnExam() {
        System.out.print("Patient took an exam: ");
        while (true) {
            try {
                int patientTookExam = Integer.parseInt((scanner.nextLine()));
                if (patientTookExam < 0 && patientTookExam > 1) {
                    throw new NumberFormatException();
                }
                return patientTookExam;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input!");
            }
        }
    }

    /*
    * getter and setter
    * */

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

}
