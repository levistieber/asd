package com.company.content;

import com.company.TeamEligibleForFerenkovAwardRule;

public class GoalsConcededRule implements TeamEligibleForFerenkovAwardRule {

    @Override
    public boolean eligibleForAward(Team team) {
        return (team.getConceded() <= team.getNumberOfMatches()*2);
    }
}
