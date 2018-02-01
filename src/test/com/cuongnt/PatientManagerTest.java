package test.com.cuongnt; 

import com.cuongnt.PatientManager;
import model.Patient;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* PatientManager Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 1, 2018</pre> 
* @version 1.0 
*/ 
public class PatientManagerTest {
    private Patient patient;
    private PatientManager patientManager;

@Before
public void before() throws Exception {
    patient = new Patient(-1,"",-1,"","",-1,-1);
    patientManager = new PatientManager();
    if (patient == null) {
        throw new Exception("Object patient is null");
    }
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getReviewedPatientList() 
* 
*/ 
@Test
public void testGetReviewedPatientList() throws Exception { 
//TODO: Test goes here...
    if (patientManager.getReviewedPatientList() == null) {
        throw new Exception("Patient reviewed list is null");
    }
    assertEquals(1,patientManager.getReviewedPatientList().size());
}

/** 
* 
* Method: addPatient() 
* 
*/ 
@Test
public void testAddPatient() throws Exception { 
//TODO: Test goes here...
    patientManager.addPatient(patient);
    if (patientManager.getPatientList() == null) {
        throw new Exception("List patient is null");
    }
    assertEquals(true, patientManager.getPatientList().contains(patient));
}

/** 
* 
* Method: inputId() 
* 
*/ 
@Test
public void testInputId() throws Exception { 
//TODO: Test goes here...
    patient.setId(10);
    if (patient.getId() == 0) {
        throw new Exception("patient id is null");
    }
    assertEquals(10, patient.getId());
} 

/** 
* 
* Method: getPatientList() 
* 
*/ 
@Test
public void testGetPatientList() throws Exception { 
//TODO: Test goes here...
    PatientManager patientManager = new PatientManager();
    if (patientManager.getPatientList() == null) {
        throw new Exception("Patient list is null");
    }
    assertEquals(3, patientManager.getPatientList().size());
}

/** 
* 
* Method: inputPatientName() 
* 
*/ 
@Test
public void testInputPatientName() throws Exception { 
//TODO: Test goes here...
    patient.setName("zakope");
    if (patient.getName() == null) {
        throw new Exception("Patient name is null");
    }
    assertEquals("zakope", patient.getName());
} 

/** 
* 
* Method: inputPatientAge() 
* 
*/ 
@Test
public void testInputPatientAge() throws Exception {
//TODO: Test goes here...
    patient.setAge(32);
    if (patient.getAge() == -1) {
        throw new Exception("patient's age is null");
    }
    assertEquals(32, patient.getAge());
} 

/** 
* 
* Method: inputPatientAddress() 
* 
*/ 
@Test
public void testInputPatientAddress() throws Exception { 
//TODO: Test goes here... 
    patient.setAddress("hanoi");
    if (patient.getAddress() == null) {
        throw new Exception("Patient's address is null");
    }
    assertEquals("hanoi", patient.getAddress());
} 

/** 
* 
* Method: inputPatientTelephone() 
* 
*/ 
@Test
public void testInputPatientTelephone() throws Exception { 
//TODO: Test goes here...
    patient.setTelephone("0912445456");
    if (patient.getTelephone() == null) {
        throw new Exception("Patient's phone number is null");
    }
    assertEquals("0912445456", patient.getTelephone());
} 

/** 
* 
* Method: inputPatientPriority() 
* 
*/ 
@Test
public void testInputPatientPriority() throws Exception { 
//TODO: Test goes here...
    patient.setPriority(2);
    if (patient.getPriority() > 3 || patient.getPriority() < 0) {
        throw new Exception("Patient's priority is not higher than 3 and lower than 0");
    }
    assertEquals(2, patient.getPriority());
} 

} 
