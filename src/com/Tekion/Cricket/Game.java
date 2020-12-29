package com.Tekion.Cricket;
import java.util.Iterator;
import java.util.Random;
import java.lang.Math;
public class Game {
    Team one;
    Team two;
    int balls;
    final int upperBound = 8;

    /**
     * Private constructor called by static factory
     * @param one the first team in the match
     * @param two the second team in the match
     * @param overs the number of overs in the match
     */
    private Game(Team one, Team two, int overs){
        this.one = one;
        this.two = two;
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
        return new Game(one,two, overs);
    }

    /**
     * Plays the game between the two teams calls the bat method
     * on both teams, then prints result. resets scores to zero for a new game
     */
    public void playGame(){
        bat(one,6*balls);
        bat(two, one.total);
        printResults();
        one.resetScores();
        two.resetScores();
    }

    /**
     * generates a random number between 0-7, indicating number of runs
     * if a 7 is chosen then considered a W or a wicket, ten wickets and youre out
     * if the second team is batting then they need to beat the first team by one ball
     * @param team the current team up for batting
     * @param max the score needed for team 2 to beat team one
     *            deafult max is the number of balls multipleid by 6 for team 1
     */
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

    /**
     * prints the results with a specific format
     * team one vs team two
     * --------------------
     * scores      scores
     * --------------------
     * total        total
     */
    private void printResults(){

        //generates headers and footers, also creates proper spacing
        System.out.println(one.getName() + " VS " + two.getName());
        int seperator = one.getName().length() + + two.getName().length() + 4;
        StringBuilder space = new StringBuilder();
        StringBuilder dash = new StringBuilder();
        dash.append("-".repeat(Math.max(0, seperator)));
        space.append(" ".repeat(Math.max(0,seperator-two.getName().length()-3)));
        System.out.println(dash);

        //uses iterators to iterat through list of scores and add to string
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

        //adds left over balls from team 1 if any
        while(o.hasNext()) {
            int hit = o.next();
            if(hit == 7){ System.out.println("W");}
            else { System.out.println(hit); }
        }

        //prints out footer and total score
        System.out.println(dash);
        System.out.println(one.total +
                space.delete(0, ((int)Math.floor(Math.log(one.total) - 2 ) )).toString()+
                            two.total);


    }
}
