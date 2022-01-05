package com.company.LeagueTest;

import com.company.*;
import com.company.content.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OutcomeTest {
    League ucl = new League();
    Owner abramovich = new Owner("Roman", "Abramovich", "1971-04-14", 957);
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);
    Manager tuchel = new Manager ("Thomas", "Tuchel", "1975-10-30", "1999-08-14");
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");
    Team psg = new Team("PSG", pochettino, mansour);
    Team chelsea = new Team("Chelsea", tuchel, abramovich);
    Match firstMatch = new Match(psg, chelsea, 2, 4);


    @Test
    void getWinnersName() throws NoWinnerException {
        ucl.addTeam(psg);
        ucl.addTeam(chelsea);
        assertEquals(ucl.getWinnersName(), "Chelsea");
    }

    @Test
    void getTable() {
        ucl.addTeam(psg);
        ucl.addTeam(chelsea);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("PSG", 0);
        expected.put("Chelsea", 3);

        assertEquals(ucl.getTable(), expected);
    }
}