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
import java.util.List;


public class PatientDao {
    private static final String PATIENT_FILE_NAME = "patient.txt";

    /*
    * Save list patient to file
    * */
    public void write(List<Patient> patientList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(new File(PATIENT_FILE_NAME));
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
    public List<Patient> read() {
        List<Patient> patientList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(PATIENT_FILE_NAME));
            ois = new ObjectInputStream(fis);
            patientList = (List<Patient>) ois.readObject();
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
