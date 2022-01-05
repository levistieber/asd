package com.company.content;

import com.company.TeamEligibleForFerenkovAwardRule;
import com.company.content.Team;

public class UndefeatedRule implements TeamEligibleForFerenkovAwardRule {

    @Override
    public boolean eligibleForAward(Team team) {
        return (team.getLosses() == 0);
    }
}
