package com.company;

import com.company.content.Manager;
import com.company.content.Owner;
import com.company.content.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Player messi = new Player ("Lionel", "Messi", "1987-06-24", 30);
    Manager tuchel = new Manager ("Thomas", "Tuchel", "1975-10-30", "1999-08-14");
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);

    @Test
    void playerAgeTest() {
        assertEquals(messi.calculateAge(), 34);
    }

    @Test
    void managerAgeTest() {
        assertEquals(tuchel.calculateAge(), 46);
    }

    @Test
    void ownerAgeTest() {
        assertEquals(mansour.calculateAge(), 31);
    }
}