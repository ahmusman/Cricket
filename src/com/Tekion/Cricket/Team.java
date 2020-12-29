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
    public List<Integer> scores;
    List<List<Integer>> allRuns;
    public int total;

    /**
     * Private Constructor that sets name of team and scores to 0
     * @param name the name of the team playing
     */
    private Team(String name){
        this.Name = name;
        scores = new ArrayList<>();
        allRuns = new ArrayList<>();
        total = 0;
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
     * getter method
     * @return the name of the team
     */
    public String getName(){
        return Name;
    }

    /**
     * resets the scores and total score to zero
     * for a new game, adds the scores to allruns before
     * to keep track of everything
     */
    public void resetScores(){
        allRuns.add(scores);
        scores= new ArrayList<>();
        total = 0;
    }


}
