package com.Tekion.Cricket;

/**
 * Game Class:
 * allows for two teams to participate in a cricket game
 * and prints the results of each game
 * games can be played forever, scores get reset after print
 */
public class Game {
    private Team one;
    private Team two;
    private int balls;
    private int matches;
    private int overs;
    final int upperBound = 8;

    /**
     * Private constructor called by static factory
     * @param one the first team in the match
     * @param two the second team in the match
     * @param overs the number of overs in the match
     */
    private Game(Team one, Team two, int overs, int matches){
        this.one = one;
        this.two = two;
        this.overs = overs;
        this.balls = 6* overs;
        this.matches = matches;
    }

    /**
     * Public static factory method to initiate a circket game
     * @param one the first team to play in the match
     * @param two the second team to play in the match
     * @param overs the number of overs in the match
     * @return returns a game object after calling constructor
     */
    public static Game createGame(Team one, Team two, int matches, int overs){
        return new Game(one,two,matches,overs);
    }

    /**
     * plays the game match number of times
     * prints out the winner of the game and by how many games
     */
    public void play(){
        System.out.println("SCORE ----- BOARD\n");
        for( int i = 0; i < matches; i++){
            playMatch(i);
        }

    }

    /**
     * Plays the game between the two teams calls the bat method
     * on both teams, then prints result. resets scores to zero for a new game
     */
    private void playMatch(int idx){
        if( idx %2 == 0){
            bat(two);
            two.resetScores();
        }
        else{
            bat(one);
            one.resetScores();
        }
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
        Bowler[] bowlers = team.getBowlers();
        Batsman[] batters = team.getBatters();

        for( int i =1; i <= this.balls; i++) {
            if (wickets == 10 ) { break; }

            int bowlerIdx = (i/6)%overs%bowlers.length;
            int hit = Utils.random();

            if (hit == 7) {
                wickets++;
                playerIdx++;
                bowlers[bowlerIdx].addWicket();
                matchStats(team,i,"W", batters[playerIdx-1]);
            }
            else{
                team.addTotal(hit);
                batters[playerIdx].addRun(hit);
                matchStats(team,i, Integer.toString(hit), batters[playerIdx]);
            }
            team.addScores(hit);
        }
    }

    /**
     * Prints of the results after every hit
     * @param team the team that was up for bat
     * @param balls the current ball that was thrown
     * @param run the runs made from hitting the ball
     * @param batter the current batter
     */
    private void matchStats(Team team, int balls, String run, Batsman batter){
        System.out.printf("Over Completed %d.%d by %s from %s with %s run hit and %d total team runs\n",
                balls/6,
                balls%6,
                batter.getName(),
                team.getName(),
                run,
                team.getTotal()
        );
//        for (Batsman bat: team.getBatters()) {
//            System.out.print(bat.getName() + " : " + bat.getRuns() + ", ");
//        }
    }

}
