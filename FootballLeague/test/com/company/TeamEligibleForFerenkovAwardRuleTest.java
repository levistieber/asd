package com.company;

import com.company.content.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamEligibleForFerenkovAwardRuleTest {
    ArrayList<TeamEligibleForFerenkovAwardRule> rules = new ArrayList<>();

    Owner abramovich = new Owner("Roman", "Abramovich", "1971-04-14", 957);
    Owner mansour = new Owner("Ali", "Mansour", "1990-02-03", 1242);
    Manager tuchel = new Manager ("Thomas", "Tuchel", "1975-10-30", "1999-08-14");
    Manager pochettino = new Manager ("Mauricio", "Pochettino", "1970-03-11", "1995-02-04");
    Team psg = new Team("PSG", pochettino, mansour);
    Team chelsea = new Team("Chelsea", tuchel, abramovich);
    Match firstMatch = new Match(psg, chelsea, 2, 4);

    @Test
    void eligibleForAwardChelsea() {
        boolean eligible = true;
        rules.add(new UndefeatedRule());
        rules.add(new GoalsScoredRule());
        rules.add(new GoalsConcededRule());

        for (TeamEligibleForFerenkovAwardRule rule : rules) {
            if (!rule.eligibleForAward(chelsea)) {
                eligible = false;
            }
        }
        assertTrue(eligible);
    }

    @Test
    void eligibleForAwardPSG() {
        boolean eligible = true;
        rules.add(new UndefeatedRule());
        rules.add(new GoalsScoredRule());
        rules.add(new GoalsConcededRule());

        for (TeamEligibleForFerenkovAwardRule rule : rules) {
            if (!rule.eligibleForAward(psg)) {
                eligible = false;
            }
        }
        assertFalse(eligible);
    }
}