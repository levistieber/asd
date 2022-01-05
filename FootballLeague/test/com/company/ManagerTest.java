package com.company;

import com.company.content.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");

    @Test
    void calculateYearsOfExperience() {
        assertEquals(pochettino.calculateYearsOfExperience(), 26);
    }
}