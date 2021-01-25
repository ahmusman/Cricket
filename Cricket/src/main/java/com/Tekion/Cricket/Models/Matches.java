package com.Tekion.Cricket.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entry;

    private int matchId;

    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private int playerId;
    private String playerName;
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private int playerScore;
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private int wickets;



    public long getEntry() {
        return entry;
    }

    public void setEntry(long entry) {
        this.entry = entry;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}

