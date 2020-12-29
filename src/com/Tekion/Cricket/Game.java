package com.Tekion.Cricket;
import java.util.Iterator;
import java.util.Random;
public class Game {
    Team one;
    Team two;
    int balls;
    final int upperBound = 8;

    private Game(Team one, Team two, int overs){
        this.one = one;
        this.two = two;
        this.balls = 6* overs;
    }

    public static Game createGame(Team one, Team two, int overs){
        return new Game(one,two, overs);
    }

    public void playGame(){
        bat(one,6*balls);
        bat(two, one.total);
        printResults();
        one.resetScores();
        two.resetScores();
    }

    private void bat(Team team, int max){
        int wickets = 0;
        Random rand = new Random();

        for( int i =0; i < this.balls; i++) {
            if (wickets == 10 || team.total > max ) { break; }
            int hit = rand.nextInt(upperBound);
            if (hit == 7) { wickets++; }
            else{ team.total += hit; }
            team.scores.add(hit);
        }
    }

    private void printResults(){
        System.out.println(one.getName() + " VS " + two.getName());
        int seperator = one.getName().length() + + two.getName().length() + 4;
        StringBuilder space = new StringBuilder();
        StringBuilder dash = new StringBuilder();
        dash.append("-".repeat(Math.max(0, seperator)));
        space.append(" ".repeat(Math.max(0,seperator-two.getName().length()-3)));
        System.out.println(dash);


        Iterator<Integer> o = one.scores.iterator();
        Iterator<Integer> t = two.scores.iterator();
        while( o.hasNext() && t.hasNext()){
            int hitOne = o.next();
            int hitTwo = t.next();
            String resOne;
            if (hitOne != 7) { resOne = Integer.toString(hitOne); } else { resOne = "W"; }
            String resTwo;
            if( hitTwo == 7){ resTwo = "W"; }
            else{ resTwo = Integer.toString(hitTwo); }

            System.out.println(resOne + space + resTwo);
        }
        while(o.hasNext()) {
            int hit = o.next();
            if(hit == 7){ System.out.println("W");}
            else { System.out.println(hit); }
        }

        System.out.println(dash);
        System.out.println(one.total + space.deleteCharAt(0).toString()+ two.total);


    }
}
