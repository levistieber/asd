package com.company;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Calculates how many years old the person is.
     * @return Returns the age in years.
     */
    public int calculateAge () {
        LocalDate today = LocalDate.now();
        return (int) (YEARS.between(this.dateOfBirth, today));
    }
}
