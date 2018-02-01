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

@Before
public void before() throws Exception { 
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
} 

/** 
* 
* Method: getPatientSearchList() 
* 
*/ 
@Test
public void testGetPatientSearchList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getReviewPatientSearchList() 
* 
*/ 
@Test
public void testGetReviewPatientSearchList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addPatient() 
* 
*/ 
@Test
public void testAddPatient() throws Exception { 
//TODO: Test goes here...
    Patient patient = new Patient(1,"pat10",12,"hanoi","0912445678",3,1);
    PatientManager patientManager = new PatientManager();
    patientManager.addPatient(patient);
    if (patientManager.getPatientList() == null) {
        throw new Exception("List patient is null");
    }
    assertEquals(true, patientManager.getPatientList().contains(patient));
}

/** 
* 
* Method: show(boolean isReviewList) 
* 
*/ 
@Test
public void testShowIsReviewList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: show(List<Patient> patients) 
* 
*/ 
@Test
public void testShowPatients() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: sortByPriority() 
* 
*/ 
@Test
public void testSortByPriority() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: inputId() 
* 
*/ 
@Test
public void testInputId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: patientIsTakeAnExam() 
* 
*/ 
@Test
public void testPatientIsTakeAnExam() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPatientList() 
* 
*/ 
@Test
public void testGetPatientList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: filterPatientsList(String condition, String patientId) 
* 
*/ 
@Test
public void testFilterPatientsList() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: inputPatientName() 
* 
*/ 
@Test
public void testInputPatientName() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PatientManager.getClass().getMethod("inputPatientName"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: inputPatientAge() 
* 
*/ 
@Test
public void testInputPatientAge() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PatientManager.getClass().getMethod("inputPatientAge"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: inputPatientAddress() 
* 
*/ 
@Test
public void testInputPatientAddress() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PatientManager.getClass().getMethod("inputPatientAddress"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: inputPatientTelephone() 
* 
*/ 
@Test
public void testInputPatientTelephone() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PatientManager.getClass().getMethod("inputPatientTelephone"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: inputPatientPriority() 
* 
*/ 
@Test
public void testInputPatientPriority() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PatientManager.getClass().getMethod("inputPatientPriority"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
