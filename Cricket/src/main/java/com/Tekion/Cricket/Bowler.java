package com.Tekion.Cricket;

/**
 * bowler class: extends Player
 * bowler has 2 atttributes,
 * Name: the name of the player
 * Wickets: the number of wickets the player hit
 */
public class Bowler extends Player {

    private int wickets;

    /**
     * constructor for creating a player
     * balls to 0
     * @param name : the name of the player
     */
    private Bowler(String name) {
        super(name);
        wickets=0;
    }

    /**
     * Static Factory method creates a new Bowler
     * @param name : name of the Bowler
     * @return a Instance of a Bowler
     */
    public static  Bowler newBowler(String name){
        return new Bowler(name);
    }

    /**
     * Public getter method
     * @return the number of wicets the bowler hit
     */
    public int getWickets() {
        return wickets;
    }

    /**
     * adds a wicket if the bowler hit a wicket
     */
    public void addWicket(){
        wickets+=1;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
