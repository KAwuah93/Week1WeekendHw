package com.example.week1weekendhw;

public class Person {

    private String fName, lName, weight, height;

    public Person(String fName, String lName, String weight, String height) {
        this.fName = fName;
        this.lName = lName;
        this.weight = weight;
        this.height = height;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
