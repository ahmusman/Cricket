package com.Tekion.Cricket.Models;



import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Games {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int matchID;

    private int overs;
    private String teamOne;
    private int scoreOne;
    private String teamTwo;
    private int scoreTwo;

    public int getMatchID() {
        return matchID;
    }

    public void getOvers(int overs) {
        this.overs = overs;
    }

    public int getScoreOne() {
        return scoreOne;
    }

    public int getScoreTwo() {
        return scoreTwo;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public void setScoreOne(int scoreOne) {
        this.scoreOne = scoreOne;
    }

    public void setScoreTwo(int scoreTwo) {
        this.scoreTwo = scoreTwo;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }



}
