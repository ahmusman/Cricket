package com.Tekion.Cricket;

/**
 * Driver class for the cricket game
 */
public class playMatch {
    public static void main(String[]args) throws InterruptedException {

        //create two teams for the the match
        Team one = Team.createTeam("England");
        Team two = Team.createTeam("New Zealand");
        Game g = Game.createGame(one, two, 50);

        //plays multiple matches until user termination
        while(true) {
            g.playGame();
            Thread.sleep(100);
        }
    }
}
