package com.company.content;

import com.company.TeamEligibleForFerenkovAwardRule;

public class GoalsScoredRule implements TeamEligibleForFerenkovAwardRule {

    @Override
    public boolean eligibleForAward(Team team) {
        return (team.getScored() >= team.getNumberOfMatches()*4);
    }
}
