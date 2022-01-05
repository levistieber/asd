package com.company.LeagueTest;

import com.company.content.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {
    League ucl = new League();
    Owner abramovich = new Owner("Roman", "Abramovich", "1971-04-14", 957);
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);
    Manager tuchel = new Manager ("Thomas", "Tuchel", "1975-10-30", "1999-08-14");
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");
    Team psg = new Team("PSG", pochettino, mansour);
    Team chelsea = new Team("Chelsea", tuchel, abramovich);
    Player messi = new Player ("Lionel", "Messi", "1987-06-24", 30);
    Player mbappe = new Player ("Kylian", "Mbappe", "1999-02-12", 12);
    Player neymar = new Player ("Jr", "Neymar", "1990-02-12", 74);
    Player kimpembe = new Player ("Maestro", "Kimpembe", "1993-08-30", 69);
    Player donnarumma = new Player ("Gianluigi", "Donnarumma", "1999-08-04", 99);
    Player kante = new Player ("Ngolo", "Kante", "1989-09-20", 8);
    Player mount = new Player ("Mason", "Mount", "1998-09-03", 10);
    Player werner = new Player ("Timo", "Werner", "1996-02-10", 11);
    Player rudiger = new Player ("Antonio", "Rudiger", "1994-11-21", 93);
    Player mendy = new Player ("Saul", "Mendy", "1997-07-14", 81);

    @Test
    void getTeamWithLowestAverageAge() {
        ucl.addTeam(psg);
        ucl.addTeam(chelsea);
        psg.addPlayer(messi);
        psg.addPlayer(mbappe);
        psg.addPlayer(neymar);
        psg.addPlayer(kimpembe);
        psg.addPlayer(donnarumma);
        chelsea.addPlayer(kante);
        chelsea.addPlayer(mount);
        chelsea.addPlayer(werner);
        chelsea.addPlayer(rudiger);
        chelsea.addPlayer(mendy);

        assertEquals(ucl.getTeamNameWithLowestAverageAge(), "Chelsea");
    }

    @Test
    void averageTeamAgeChelsea() {
        ucl.addTeam(chelsea);
        chelsea.addPlayer(kante);
        chelsea.addPlayer(mount);
        chelsea.addPlayer(werner);
        chelsea.addPlayer(rudiger);
        chelsea.addPlayer(mendy);

        assertEquals(chelsea.calculateAverageAge(), 26.2);
    }

    @Test
    void averageTeamAgePSG() {
        ucl.addTeam(psg);
        psg.addPlayer(messi);
        psg.addPlayer(mbappe);
        psg.addPlayer(neymar);
        psg.addPlayer(kimpembe);
        psg.addPlayer(donnarumma);

        assertEquals(psg.calculateAverageAge(), 27.4);
    }
}