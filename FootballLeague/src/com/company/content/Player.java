package com.company.content;

import com.company.Person;

public class Player extends Person {
    private int shirtNumber;

    public Player(String firstName, String lastName, String dateOfBirth, int shirtNumber) {
        super(firstName, lastName, dateOfBirth);
        this.shirtNumber = shirtNumber;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }
}