package com.Tekion.Cricket.Controllers;

import com.Tekion.Cricket.Models.Games;
import com.Tekion.Cricket.Models.Players;
import com.Tekion.Cricket.Models.Series;
import com.Tekion.Cricket.Models.Matches;
import com.Tekion.Cricket.Service.CricketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/cricket")
public class mainController{

    @Autowired
    CricketServices service;

    @PostMapping(path = "/play")
    public @ResponseBody String
    startGame(@RequestParam int numMatches, @RequestParam int numOvers){
        return service.initiateGame(numMatches, numOvers);
    }

    @GetMapping(path = "/winner")
    public @ResponseBody String
    getWinner(){
        return service.seriesWinner();
    }

    @GetMapping(path="/games")
    public @ResponseBody Iterable<Games>
    getAllGames(){
        return service.findAllGames();
    }

    @GetMapping(path = "/series")
    public @ResponseBody Iterable<Series>
    getSeries(){
        return service.showAllSeries();
    }

    @GetMapping(path = "/series/id")
    public @ResponseBody Optional<Series>
    getSeriesById(@RequestParam int id){
        return service.showSeries(id);
    }

    @GetMapping(path = "/series/team")
    public @ResponseBody Iterable<Series>
    getSeriesWonBy(@RequestParam(value = "teamName") String teamName){
        return service.showSeriesWonBy(teamName);
    }

    @GetMapping(path = "/matches")
    public @ResponseBody Iterable<Matches> getMatches(){
        return service.showAllMatches();
    }

    @GetMapping(path = "/matches/player")
    public @ResponseBody Iterable<Matches> getPlayersMatches(@RequestParam(value = "name") String player){
        return service.getMatchesByPlayer(player);
    }

    @GetMapping(path = "/matches/number")
    public @ResponseBody Iterable<Matches> getMatchNumber(@RequestParam(value = "number") int matchNum){
        return service.getMatchesByMatchNum(matchNum);
    }

    @GetMapping(path = "/players/team")
    public @ResponseBody Iterable<Players>
    getTeam(@RequestParam(value = "teamName") String teamName){
        return service.findPlayersByTeam(teamName);
    }

    @GetMapping(path="/players")
    public @ResponseBody Iterable<Players>
    getAllPlayers(){
        return service.findAllPlayers();
    }

    @GetMapping(path = "/players/")
    public @ResponseBody Optional<Players>
    getPlayer(@RequestParam(value = "id") int id){
        return service.findPlayerById(id);
    }

    @GetMapping(path = "/players/Batters")
    public @ResponseBody Iterable<Players> getBatters(){
        return service.findAllBatters();
    }

    @GetMapping(path = "/players/Bowlers")
    public @ResponseBody Iterable<Players> getBowlers(){
        return service.findAllBowlers();
    }

    @GetMapping(path = "/players/name")
    public @ResponseBody Iterable<Players>
    getPlayersByName(@RequestParam(value = "playerName") String playerName){
        return service.findPlayersByName(playerName);
    }

    @GetMapping(path = "/players/runs")
    public @ResponseBody Iterable<Players>
    getPlayersRuns(@RequestParam(name = "runs") int runs){
        return service.findPlayersWithAtLeastRuns(runs);
    }
}
