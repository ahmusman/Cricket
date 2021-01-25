package com.Tekion.Cricket.Service;

import com.Tekion.Cricket.Helpers.Game;
import com.Tekion.Cricket.Models.Games;
import com.Tekion.Cricket.Models.Matches;
import com.Tekion.Cricket.Models.Players;
import com.Tekion.Cricket.Models.Series;
import com.Tekion.Cricket.Repositories.*;
import com.Tekion.Cricket.Models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class CricketServices implements Services {
    int ctr = 0;
    private Game g;
    private final Team teamOne = Team.createTeam("England");
    private final Team teamTwo = Team.createTeam("New Zealand");

    @Autowired
    private GamesRepository gamesRepo;
    @Autowired
    private SeriesRepository seriesRepo;
    @Autowired
    private MatchesRepository matchesRepo;
    @Autowired
    private PlayersRepository playersRepo;

    @Override
    public Iterable<Games> findAllGames(){
        return gamesRepo.findAll();
    }

    @Override
    public Iterable<Players> findAllPlayers() {
        return playersRepo.findAll();
    }

    @Override
    public Iterable<Players> findAllBatters() {
        return playersRepo.findBatters();
    }

    @Override
    public Iterable<Players> findAllBowlers() {
        return playersRepo.findBowlers();
    }

    @Override
    public Iterable<Players> findPlayersByTeam(String teamName) {
        return playersRepo.findByTeam(teamName);
    }

    @Override
    public Optional<Players> findPlayerById(int id) {
        return playersRepo.findById(id);
    }

    @Override
    public Iterable<Players> findPlayersByName(String playerName) {
        return playersRepo.findPlayersNamed(playerName);
    }

    @Override
    public Iterable<Players> findPlayersWithAtLeastRuns(int runs) {
        return playersRepo.findPlayersWithRuns(runs);
    }

    @Override
    public String seriesWinner() {
        return g.seriesWinner();
    }

    @Override
    public Iterable<Series> showAllSeries() { return seriesRepo.findAll(); }

    @Override
    public Optional<Series> showSeries(int seriesId) {
        return seriesRepo.findById(seriesId);
    }

    @Override
    public Iterable<Series> showSeriesWonBy(String winner){
        return seriesRepo.seriesWonBy(winner);
    }

    @Override
    public Iterable<Matches> showAllMatches() {
        return matchesRepo.findAll();
    }

    @Override
    public Iterable<Matches> getMatchesByPlayer(String name) {
        return matchesRepo.getPlayersMatches(name);
    }

    @Override
    public Iterable<Matches> getMatchesByMatchNum(int matchNum) {
        return matchesRepo.getMatchById(matchNum);
    }

    @Override
    public String initiateGame(int numMatches, int numOvers) {
        setGame(numMatches, numOvers);
        return "The Cricket game has been played";
    }

    /**
     * initalize the game with teams and the number of overs
     * keeps track of each macthes data and stores it
     * @param numMatches
     * @param numOvers
     */
    private void setGame(int numMatches, int numOvers){
        createPlayers();
        g = Game.createGame(teamOne, teamTwo, numOvers);

        for (int i = 0; i <numMatches ; i++) {
            gamesRepo.save(g.play());
            matchData(i);
        }
        addPlayersToFinal();
        addSeries();
    }

    /**
     * Genrates a set of 10 bowlers and 10 batters for each team
     */
    private void createPlayers(){
        for(int i=0; i < 10; i++){
            teamOne.addBatter(addPlayerToGame("england" +i, teamOne.getName(), 1));
            teamOne.addBowlers(addPlayerToGame("Bowler_E_"+ i, teamOne.getName(), 2));
            teamTwo.addBatter(addPlayerToGame("new zealand " + i, teamTwo.getName(), 1));
            teamTwo.addBowlers(addPlayerToGame("Bowler_Z_"+i, teamTwo.getName(), 2));
        }
    }

    /**
     * helper method to save players to repo
     */
    private void addPlayersToFinal(){
        for(int i =0; i < 10; i++){
            playersRepo.save(teamOne.getBatters()[i]);
        }
        for (int i = 0; i < 10; i++) {
            playersRepo.save(teamTwo.getBatters()[i]);
        }
        for (int i = 0; i < 10; i++) {
            playersRepo.save(teamOne.getBowlers()[i]);
        }
        for (int i = 0; i < 10; i++) {
            playersRepo.save(teamTwo.getBowlers()[i]);
        }

    }

    /**
     * creates player helper method for setting game
     * @param name
     * @param teamName
     * @param type
     * @return
     */
    private Players addPlayerToGame(String name, String teamName, int type){
        Players p = new Players();
        p.setName(name);
        p.setTeam(teamName);
        p.setOuts(0);
        p.setRuns(0);
        p.setWickets(0);
        p.setPlayerType(type);
        return p;
    }

    /**
     * stores each series data, with runs and winner
     */
    private void addSeries(){
        Series s = new Series();
        s.setTeamOne(teamOne.getName());
        s.setTeamTwo(teamTwo.getName());
        s.setScoreTwo(teamTwo.getGamesWon());
        s.setScoreOne(teamOne.getGamesWon());
        if(teamOne.getGamesWon() > teamTwo.getGamesWon()){
            s.setWinner(teamOne.getName());
        }else{
            s.setWinner(teamTwo.getName());
        }
        seriesRepo.save(s);

    }

    /**
     * helper : stores the data of each much with a running total of runs for each player
     * as well as outs and wickets for all players
     * @param matchId
     */
    private void matchData(int matchId){
        List<Players> temp = new ArrayList<>(teamOne.getAllPlayers());
        temp.addAll(teamTwo.getAllPlayers());
        for (Players p : temp) {
            Matches m = new Matches();
            m.setMatchId(matchId);
            m.setPlayerId(p.getPlayerId());
            m.setPlayerName(p.getName());
            m.setPlayerScore(p.getRuns());
            m.setWickets(p.getWickets());
            matchesRepo.save(m);
        }
    }

}
