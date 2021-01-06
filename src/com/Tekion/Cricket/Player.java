package com.Tekion.Cricket;

/**
 * Player class
 * player has two attritbutes
 * Name - the players name
 * runs - the number of runs the player completed
 */
public class Player {
    private String name;

    /**
     * Private constructor for creating a player
     * runs to 0
     * @param name : the name of the player
     */
    public Player(String name) {

        this.name = name;
    }

    /**
     * getter method for name
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
}
