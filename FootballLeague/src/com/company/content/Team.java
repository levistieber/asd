package com.company.content;

import com.company.content.Manager;
import com.company.content.Owner;
import com.company.content.Player;

import java.util.HashSet;

public class Team {
    private String name;
    private HashSet<Player> players;
    private Manager manager;
    private Owner owner;
    private int points;
    private int wins;
    private int draws;
    private int losses;
    private int scored;
    private int conceded;

    public Team(String name, Manager manager, Owner owner) {
        this.name = name;
        this.manager = manager;
        this.owner = owner;
        this.points = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.scored = 0;
        this.conceded = 0;
        this.players = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    public HashSet<String> getPlayersNames() {
        HashSet<String> playersNames = new HashSet<>();
        for (Player player : this.players) {
            playersNames.add(player.getLastName());
        }
        return playersNames;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getNumberOfMatches() {
        return (this.wins + this.draws + this.losses);
    }

    public int getScored() {
        return scored;
    }

    public int getConceded() {
        return conceded;
    }

    /**
     * If the team won, gives them 3 points and 1 win.
     */
    public void teamWon() {
        this.points += 3;
        this.wins += 1;
    }

    /**
     * If the scores of a match is equal, the team gets 1 point and 1 draw.
     */
    public void teamDrew() {
        this.points += 1;
        this.draws += 1;
    }

    /**
     * If the team lost the match, gives the team 1 loss.
     */
    public void teamLost() {
        this.losses += 1;
    }

    /**
     * Adds the goals scored on the match to the team's goals.
     * @param goals - number of goals scored on the match.
     */
    public void goalsScored(int goals) {
        this.scored = this.scored + goals;
    }

    /**
     * Adds the goals conceded on the match to the team's conceded goals.
     * @param goals - number of goals conceded on the match.
     */
    public void goalsConceded(int goals) {
        this.conceded = this.conceded + goals;
    }

    /**
     * Calculates the team's goal difference
     * @return Returns the goals conceded taken away from the goals scored.
     */
    public int calculateGoalDifference() {
        return scored - conceded;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * Calculates the average age of the assigned players to the team.
     * @return Returns average age in years of the team members.
     */
    public double calculateAverageAge() {
        double average = 0;
        for (Player player : this.players) {
            average = average + player.calculateAge();
        }
        return average/this.players.size();
    }

    /**
     * Information of the manager and the owner.
     * @return Returns the manager's and the owner's info.
     */
    public String getStaffMembersInfo() {
        return "Manager: " + this.manager.toString() + ", Owner: " + this.owner.toString();
    }
}