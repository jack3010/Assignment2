package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Patient {

    // Instance variables
    int id;
    String name;
    int age;
    String address;
    String telephone;
    int priority;
    int isExaminated;

    // Constructor declaration of class
    public Patient(int id, String name, int age, String address, String telephone, int priority, int isExaminated) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
        this.priority = priority;
        this.isExaminated = isExaminated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int isExaminated() {
        return isExaminated;
    }

    public void setExaminated(int examinated) {
        isExaminated = examinated;
    }

}
