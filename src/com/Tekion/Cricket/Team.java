package com.Tekion.Cricket;
import java.util.ArrayList;
import java.util.List;
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

    public String getName(){
        return Name;
    }

    public void resetScores(){
        scores= new ArrayList<>();
        total = 0;
    }


}
