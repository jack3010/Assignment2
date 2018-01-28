package com.cuongnt;

import model.Patient;
import java.util.Comparator;

public class SortPatientByPriority implements Comparator<Patient>{
    @Override
    public int compare(Patient patientLeft, Patient patientRight) {
        if (patientRight.getPriority() > patientLeft.getPriority()) {
            return 1;
        }
        return -1;
    }
}
