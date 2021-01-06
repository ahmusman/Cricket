package com.Tekion.Cricket;

public class Batsman extends Player{

    private int runs;

    /**
     * Constructor for creating a player
     * runs to 0
     * @param name : the name of the player
     */
    private Batsman(String name) {
        super(name);
        runs = 0;
    }

    /**
     * Static Factory method for batsman
     * @param name of the batter
     * @return a batsman object
     */
    public static Batsman newBatter(String name){
        return new Batsman(name);
    }

    /**
     * public getter method for the runs
     * @return the number of runs the batter has ran
     */
    public int getRuns() {
        return runs;
    }

    /**
     * public adder method to class
     * @param runs the runs to be added
     */
    public void addRun(int runs){
        this.runs+= runs;
    }
}
