package com.cuongnt;

import model.Patient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class PatientDao {
    private static final String PATIENT_FILE_NAME = "patient.txt";
    private static final String REVIEW_PATIENT_FILE_NAME = "review_list.txt";

    /*
    * Save list patient to file
    * */
    public void write(List<Patient> patientList, boolean isReviewList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(new File(isReviewList ? REVIEW_PATIENT_FILE_NAME : PATIENT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(patientList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
        }
    }

    /*
    * Read list Patient from file
    * */
    public LinkedList<Patient> readToLinkedList() {
        LinkedList<Patient> patientList = new LinkedList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File targetFile = new File(PATIENT_FILE_NAME);
        try {
            if (!targetFile.exists()) {
                patientList = new LinkedList<>();
            } else {
                fis = new FileInputStream(targetFile);
                ois = new ObjectInputStream(fis);
                patientList = (LinkedList<Patient>) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return patientList;
    }

    public Stack<Patient> readToStack() {
        Stack<Patient> patientList = new Stack<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File targetFile = new File(REVIEW_PATIENT_FILE_NAME);
        try {
            if (!targetFile.exists()) {
                patientList = new Stack<>();
            } else {
                fis = new FileInputStream(targetFile);
                ois = new ObjectInputStream(fis);
                patientList = (Stack<Patient>) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return patientList;
    }

    /*
    Close input stream
    * */
    public void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*
    Close output stream
    * */
    public void closeStream(OutputStream os){
        if (os != null) {
            try {
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
