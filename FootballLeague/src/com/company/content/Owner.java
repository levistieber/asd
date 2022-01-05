package com.company.content;

import com.company.Person;

public class Owner extends Person {
    private int capital;

    public Owner(String firstName, String lastName, String dateOfBirth, int capital) {
        super(firstName, lastName, dateOfBirth);
        this.capital = capital;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
}
