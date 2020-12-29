package com.Tekion.Cricket;
public class playMatch {
    public static void main(String[]args) {
        Team one = Team.createTeam("England");
        Team two = Team.createTeam("New Zealand");
        Game g = Game.createGame(one, two, 50);
        while(true) g.playGame();

    }
}
