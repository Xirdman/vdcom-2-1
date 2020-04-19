package com.example.vdcom21.model;

public class MtgPlayer {
    private int id;
    private String firstName,lastName,dciNumber;

    public MtgPlayer() {
    }

    public MtgPlayer(int id, String firstName, String lastName, String dciNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dciNumber = dciNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDciNumber(String dciNumber) {
        this.dciNumber = dciNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDciNumber() {
        return this.dciNumber;
    }
}
