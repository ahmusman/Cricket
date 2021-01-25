package com.Tekion.Cricket.Models;

import javax.persistence.*;

@Entity
@Table(name = "Series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String teamOne;
    private int scoreOne;
    private String teamTwo;
    private int ScoreTwo;
    private String winner;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setScoreOne(int scoreOne) {
        this.scoreOne = scoreOne;
    }

    public int getScoreOne() {
        return scoreOne;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setScoreTwo(int scoreTwo) {
        ScoreTwo = scoreTwo;
    }

    public int getScoreTwo() {
        return ScoreTwo;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }
}
