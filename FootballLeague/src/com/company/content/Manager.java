package com.company.content;

import com.company.Person;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class Manager extends Person {
    private LocalDate activeSince;

    public Manager(String firstName, String lastName, String dateOfBirth, String activeSince) {
        super(firstName, lastName, dateOfBirth);
        this.activeSince = LocalDate.parse(activeSince);
    }

    public LocalDate getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(LocalDate activeSince) {
        this.activeSince = activeSince;
    }

    /**
     * Calculates how many years the manager has been active for.
     * @return Returns the active years.
     */
    public int calculateYearsOfExperience() {
        LocalDate today = LocalDate.now();
        return (int)(YEARS.between(this.activeSince, today));
    }
}