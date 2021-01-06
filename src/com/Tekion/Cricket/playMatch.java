package com.Tekion.Cricket;

/**
 * Driver class for the cricket game
 */
public class playMatch {
    public static void main(String[]args) {
        int numMatches;
        int numOvers;

        //creates the neccesary teams and players for a game
        Team one = Team.createTeam("England");
        Team two = Team.createTeam("New Zealand");
        for (int i = 0; i < 10; i++) {
            one.addBatter(Batsman.newBatter("english"+ i));
            two.addBatter(Batsman.newBatter("zealandish" + i));
        }

        for (int i = 0; i < 5; i++) {
            one.addBowlers(Bowler.newBowler("bowl Eng" + i ));
            two.addBowlers(Bowler.newBowler("bowl zeal" + i ));

        }

        /**
         * parses command line with default values of mathches and overs
         */
        try{
            numMatches = Integer.parseInt(args[0]);
            numOvers = Integer.parseInt(args[1]);
        }catch(Exception e){
            numMatches=1;
            numOvers = 10;
        }

        //creates a game and plays
        Game g = Game.createGame(one, two, numMatches, numOvers);
        g.play();
    }
}
