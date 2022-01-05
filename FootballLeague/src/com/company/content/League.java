package com.company.content;

import com.company.NoWinnerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class League {
    private HashSet<Team> teams;

    public League() {
        this.teams = new HashSet<>();
    }

    public HashSet<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    /**
     * Checks which team has the most points. If not only one, then checks which of those has a better goal difference. If that also leaves several teams, the one with the most goals scored wins. If everything is still the same, the team will be chosen randomly out of these teams.
     * @return Returns the winner team of the tournament.
     */
    public Team getWinner() {
        int maxPoint = -1;
        Team winner = null;

        for (Team team : this.teams) {
            if (team.getPoints() > maxPoint) {
                maxPoint = team.getPoints();
            }
        }
        ArrayList<Team> teamsWithMostPoints = new ArrayList<>();
        for (Team team : this.teams) {
            if (team.getPoints() == maxPoint) {
                teamsWithMostPoints.add(team);
            }
        }
        if (teamsWithMostPoints.size() == 1) {
            winner = teamsWithMostPoints.get(0);
        }
        else {
            int maxGoalDifference = -1;
            ArrayList<Team> teamsGoalDifferenceWithMostPoints = new ArrayList<>();
            for (Team team : teamsWithMostPoints) {
                if (team.calculateGoalDifference() > maxGoalDifference) {
                    maxGoalDifference = team.calculateGoalDifference();
                }
            }
            for (Team team : teamsWithMostPoints) {
                if (team.calculateGoalDifference() == maxGoalDifference) {
                    teamsGoalDifferenceWithMostPoints.add(team);
                }
            }
            if (teamsGoalDifferenceWithMostPoints.size() == 1) {
                winner = teamsGoalDifferenceWithMostPoints.get(0);
            }
            else {
                int maxGoalsScored = -1;
                ArrayList<Team> teamsScoredWithMostPoints = new ArrayList<>();
                for (Team team : teamsGoalDifferenceWithMostPoints) {
                    if (team.getScored() > maxGoalsScored) {
                        maxGoalsScored = team.getScored();
                    }
                }
                for (Team team : teamsGoalDifferenceWithMostPoints) {
                    if (team.getScored() == maxGoalsScored) {
                        teamsScoredWithMostPoints.add(team);
                    }
                }
                if (teamsScoredWithMostPoints.size() == 1) {
                    winner = teamsScoredWithMostPoints.get(0);
                }
                else {
                    Collections.shuffle(teamsScoredWithMostPoints);
                    winner = teamsScoredWithMostPoints.get(0);
                }
            }
        }
        return winner;
    }

    public String getWinnersName() throws NoWinnerException {
        try {
            return getWinner().getName();
        }
        catch (Exception e) {
            throw new NoWinnerException();
        }
    }

    /**
     * The overview of the table.
     * @return Returns the teams in the league and their scores.
     */
    public HashMap getTable() {
        HashMap<String, Integer> table = new HashMap<>();

        for (Team team : this.teams) {
            table.put(team.getName(), team.getPoints());
        }

        return table;
    }

    /**
     * Checks the average age of the players of each team and picks the one with the lowest.
     * @return Returns the team with the lowest average player age.
     */
    public Team getTeamWithLowestAverageAge() {
        Team oneTeam = this.teams.iterator().next();
        double lowest = oneTeam.calculateAverageAge();
        Team teamWithLowest = oneTeam;
        for (Team team : this.teams) {
            if (team.calculateAverageAge() < lowest) {
                teamWithLowest = team;
            }
        }
        return teamWithLowest;
    }

    public String getTeamNameWithLowestAverageAge() {
        return getTeamWithLowestAverageAge().getName();
    }

    public HashMap<String, Integer> getOverviewOfTeamsWealth() {
        HashMap<String, Integer> overview = new HashMap<>();
        for (Team team : this.teams) {
            overview.put(team.getName(), team.getOwner().getCapital());
        }
        return overview;
    }
}