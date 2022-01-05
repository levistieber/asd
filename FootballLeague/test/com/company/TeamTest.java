package com.company;

import com.company.content.Manager;
import com.company.content.Owner;
import com.company.content.Player;
import com.company.content.Team;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");
    Team psg = new Team("PSG", pochettino, mansour);
    Player messi = new Player ("Lionel", "Messi", "1987-06-24", 30);
    Player mbappe = new Player ("Kylian", "Mbappe", "1999-02-12", 12);
    Player neymar = new Player ("Jr", "Neymar", "1990-02-12", 74);
    Player kimpembe = new Player ("Maestro", "Kimpembe", "1993-08-30", 69);
    Player donnarumma = new Player ("Gianluigi", "Donnarumma", "1999-08-04", 99);
    HashSet<String> expected = new HashSet<>();

    @Test
    void getPlayers() {
        psg.addPlayer(messi);
        psg.addPlayer(mbappe);
        psg.addPlayer(neymar);
        psg.addPlayer(kimpembe);
        psg.addPlayer(donnarumma);

        expected.add("Kimpembe");
        expected.add("Donnarumma");
        expected.add("Neymar");
        expected.add("Mbappe");
        expected.add("Messi");

        assertEquals(psg.getPlayersNames(), expected);
    }
}