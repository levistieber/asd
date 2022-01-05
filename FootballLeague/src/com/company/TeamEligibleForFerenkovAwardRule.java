package com.company;

import com.company.content.Team;

/**
 * Checks whether the conditions are met for the team to get the award.
 */
public interface TeamEligibleForFerenkovAwardRule {
    boolean eligibleForAward(Team team);
}
