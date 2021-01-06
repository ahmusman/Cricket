package com.Tekion.Cricket;
import java.util.ArrayList;
import java.util.List;

/**
 * Team class:
 * a team has three attributes;
 * Name
 * Scores - a list of runs per ball
 * Total - the total number of runs
 * allRuns - list of all the runs the team has ever ran
 */

public class Team {
    private final String Name;
    private int total = 0;
    private int runningTotal;
    private int gamesWon=0;
    private List<Integer> scores = new ArrayList<>();
    private final List<List<Integer>> allRuns = new ArrayList<>();
    private final List<Batsman> batters = new ArrayList<>();
    private final List<Bowler> bowlers = new ArrayList<>();

    /**
     * Private Constructor that sets name of team and scores to 0
     * @param name the name of the team playing
     */
    private Team(String name){
        this.Name = name;
    }

    /**
     * Static factory method creates and initializes a team
     * @param name the name of the team to create
     * @return returns a team object with scores set to zero
     */
    public static Team createTeam(String name){
        return new Team(name);
    }

    /**
     * adds a Batter to the teams batter players
     * @param player the palyer to be added to the team
     */
    public void addBatter(Batsman player){ batters.add(player); }


    /**
     * getter method for the Batters on the team
     * @return a list of Batters to the team
     */
    public Batsman[] getBatters(){
        Batsman[] arr = new Batsman[batters.size()];
        return batters.toArray(arr);

    }

    /**
     * adds bowler to the team
     * @param player the player to be added
     */
    public void addBowlers(Bowler player){
        bowlers.add(player);
    }

    /**
     * returns an array of bowlers
     * @return an array of bowlers
     */
    public Bowler[] getBowlers() {
        Bowler[] arr = new Bowler[bowlers.size()];
        return bowlers.toArray(arr);
    }

    /**
     * getter method
     * @return the name of the team
     */
    public String getName(){
        return Name;
    }

    /**
     * getter method for total runs in a game
     * @return the
     */
    public int getTotal() {
        return total;
    }

    /**
     * adds to total number of runs
     * @param hit the newest run to add
     */
    public void addTotal( int hit){
        total += hit;
    }


    /**
     * resets the scores and total score to zero
     * for a new game, adds the scores to allruns before
     * to keep track of everything
     */
    public void resetScores(){
        allRuns.add(scores);
        scores= new ArrayList<>();
        runningTotal += total;
        total = 0;
    }

    /**
     * increments the gamesWon instance by one
     */
    public void win(){
        gamesWon+=1;
    }

    /**
     * getter method for gamesWon
     * @return the number of games won by the team
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * adds score to the teams match score
     * @param hit the runs to be added from recent hit
     */
    public void addScores(int hit){
        scores.add(hit);
    }

    /**
     * getter method for running total
     * @return the total runs by the team during the entire match
     */
    public int getRunningTotal() {
        return runningTotal;
    }
}
