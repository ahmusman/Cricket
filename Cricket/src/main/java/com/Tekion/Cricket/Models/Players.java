package com.Tekion.Cricket.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Players")
public class Players implements Serializable {



    @Id
    @Cascade(value = org.hibernate.annotations.CascadeType.PERSIST)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;
    private String name;
    private String team;
    private int playerType; //1 for batter 2 for bowler
    private int runs;
    private int outs;
    private int wickets;


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int matchId) {
        this.playerId = matchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerType(int playerType) {
        this.playerType = playerType;
    }

    public int getPlayerType() {
        return playerType;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
