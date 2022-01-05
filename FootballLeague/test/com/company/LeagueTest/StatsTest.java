package com.company.LeagueTest;

import com.company.content.Manager;
import com.company.content.Match;
import com.company.content.Owner;
import com.company.content.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {
    Owner abramovich = new Owner("Roman", "Abramovich", "1971-04-14", 957);
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);
    Manager tuchel = new Manager ("Thomas", "Tuchel", "1975-10-30", "1999-08-14");
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");
    Team psg = new Team("PSG", pochettino, mansour);
    Team chelsea = new Team("Chelsea", tuchel, abramovich);
    Match firstMatch = new Match(psg, chelsea, 2, 4);

    @Test
    void pointsPSG() {
        assertEquals(psg.getPoints(), 0);
    }

    @Test
    void winsPSG() {
        assertEquals(psg.getWins(), 0);
    }

    @Test
    void drawsPSG() {
        assertEquals(psg.getDraws(), 0);
    }

    @Test
    void lossesPSG() {
        assertEquals(psg.getLosses(), 1);
    }

    @Test
    void scoredPSG() {
        assertEquals(psg.getScored(), 2);
    }

    @Test
    void concededPSG() {
        assertEquals(psg.getConceded(), 4);
    }

    @Test
    void goalDiffPSG() {
        assertEquals(psg.calculateGoalDifference(), -2);
    }

    @Test
    void pointsChelsea() {
        assertEquals(chelsea.getPoints(), 3);
    }

    @Test
    void winsChelsea() {
        assertEquals(chelsea.getWins(), 1);
    }

    @Test
    void drawsChelsea() {
        assertEquals(chelsea.getDraws(), 0);
    }

    @Test
    void lossesChelsea() {
        assertEquals(chelsea.getLosses(), 0);
    }

    @Test
    void scoredChelsea() {
        assertEquals(chelsea.getScored(), 4);
    }

    @Test
    void concededChelsea() {
        assertEquals(chelsea.getConceded(), 2);
    }

    @Test
    void goalDiffChelsea() {
        assertEquals(chelsea.calculateGoalDifference(), 2);
    }
}