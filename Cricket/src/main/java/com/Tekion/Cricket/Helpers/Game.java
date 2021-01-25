package com.Tekion.Cricket.Helpers;

import com.Tekion.Cricket.Models.Games;
import com.Tekion.Cricket.Models.Players;
import com.Tekion.Cricket.Models.Team;
import com.Tekion.Cricket.Utils.*;


/**
 * Game Class:
 * allows for two teams to participate in a cricket game
 * and prints the results of each game
 * games can be played forever, scores get reset after print
 */
public class Game {

    private Team teamOne;
    private Team teamTwo;
    private int balls;
    private int numMatches;
    private int overs;


    /**
     * Private constructor called by static factory
     * @param teamOne the first team in the match
     * @param teamTwo the second team in the match
     * @param overs the number of overs in the match
     */
    private Game(Team teamOne, Team teamTwo, int overs){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.overs = overs;
        this.balls = 6* overs;
    }

    /**
     * Public static factory method to initiate a circket game
     * @param one the first team to play in the match
     * @param two the second team to play in the match
     * @param overs the number of overs in the match
     * @return returns a game object after calling constructor
     */
    public static Game createGame(Team one, Team two, int overs){
        return new Game(one,two,overs);
    }

    /**
     * plays the game match number of times
     * prints out the winner of the game and by how many games
     */
    public Games play(){ return playMatch(); }

    /**
     * Plays the game between the two teams calls the bat method
     * on both teams, then prints result. resets scores to zero for a new game
     */
    private Games playMatch(){

        bat(teamTwo);
        bat(teamOne);
        won();
        Games m = new Games();
        m.setOvers(this.overs);
        m.setTeamOne(teamOne.getName());
        m.setTeamTwo(teamTwo.getName());
        m.setScoreOne(teamOne.getTotal());
        m.setScoreTwo(teamTwo.getTotal());
        teamTwo.resetScores();
        teamOne.resetScores();
        return m;
    }

    /**
     * generates a random number between 0-7, indicating number of runs
     * if a 7 is chosen then considered a W or a wicket, ten wickets and youre out
     * if the second team is batting then they need to beat the first team by one ball
     * @param team the current team up for batting
     */
    private void bat(Team team){
        int wickets = 0;
        int playerIdx=0;
        Players[] bowlers = team.getBowlers();
        Players[] batters = team.getBatters();

        for( int i =1; i <= this.balls; i++) {
            if (wickets == 10 ) { break; }

            int bowlerIdx = (i/6)%overs%bowlers.length;
            int hit = Utils.random();

            if (hit == 7) {
                wickets++;
                batters[playerIdx].setOuts(batters[playerIdx].getOuts()+1);
                playerIdx++;
                bowlers[bowlerIdx].setWickets(bowlers[bowlerIdx].getWickets()+1);
            }
            else{
                team.addTotal(hit);
                batters[playerIdx].setRuns(batters[playerIdx].getRuns()+hit);
            }
            team.addScores(hit);
        }
    }


    public String seriesWinner(){
        if( teamOne.getGamesWon() > teamTwo.getGamesWon()){
            return("The Winner of the series is " + teamOne.getName());
        }
        else{
            return ("The Winner of the series is " + teamTwo.getName());
        }
    }

    public void won(){
        if(teamOne.getTotal() > teamTwo.getTotal()){
            teamOne.win();
        }
        else{
            teamTwo.win();
        }
    }
}

