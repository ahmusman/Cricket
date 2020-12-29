package com.Tekion.Cricket;
import java.util.ArrayList;
import java.util.List;

/**
 * Team class:
 * a team has three attributes;
 * Name
 * Scores - a list of runs per ball
 * Total - the total number of runs
 */

public class Team {
    private final String Name;
    public List<Integer> scores;
    public int total;

    private Team(String name){
        this.Name = name;
        scores = new ArrayList<>();
        total = 0;
    }

    //static factory method with private constructor
    public static Team createTeam(String name){
        return new Team(name);
    }

    //returns the name of the team
    public String getName(){
        return Name;
    }

    //resets the score of the team for another match
    public void resetScores(){
        scores= new ArrayList<>();
        total = 0;
    }


}
