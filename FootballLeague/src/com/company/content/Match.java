package com.company.content;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;

    public Match(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.determineOutCome();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    /**
     * Checks the outcome of the match and gives the teams their points and goals.
     */
    public void determineOutCome() {
        if (this.homeGoals > this.awayGoals) {
            this.homeTeam.teamWon();
            this.awayTeam.teamLost();
        }
        else if (this.awayGoals > this.homeGoals) {
            this.awayTeam.teamWon();
            this.homeTeam.teamLost();
        }
        else {
            this.homeTeam.teamDrew();
            this.awayTeam.teamDrew();
        }

        this.homeTeam.goalsScored(this.homeGoals);
        this.homeTeam.goalsConceded(this.awayGoals);
        this.awayTeam.goalsScored(this.awayGoals);
        this.awayTeam.goalsConceded(this.homeGoals);
    }
}