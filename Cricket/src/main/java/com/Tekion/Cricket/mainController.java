package com.Tekion.Cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.Tekion.Cricket.Players;


@Controller
@RequestMapping(path="/cricket")
public class mainController {

    //should be in services
    @Autowired
    private MatchRepository matches;
    @Autowired
    private PlayersRepository playersRepo;

    Game g;
    Team teamOne = Team.createTeam("England");
    Team teamTwo = Team.createTeam("New Zealand");


    @PostMapping(path = "/game")
    public @ResponseBody String startGame(@RequestParam int numMatches, @RequestParam int numOvers){
        //cleanUp();
        //add this into a service class interface and implementations class
        createPlayers();
        g = Game.createGame(teamOne, teamTwo, numMatches, numOvers);
        g.play();
        List<Matches> m = g.getMatches();
        for(int i =0; i < m.size(); i++){
            matches.save(m.get(i));
        }
        addAllPlayers();
        return "game played";
    }

    @GetMapping(path="/matches")
    public @ResponseBody Iterable<Matches> getAllMatches(){
        return matches.findAll();
    }

    @GetMapping(path="/players")
    public @ResponseBody Iterable<Players> getAllPlayers(){
        return playersRepo.findAll();
    }

    @GetMapping(path = "/players/{id}")
    public @ResponseBody Optional<Players> getPlayer(@PathVariable(value = "id") int id){
        return playersRepo.findById(id);
    }

    @GetMapping(path = "/winner")
    public @ResponseBody String getWinner(){
        return g.seriesWinner();
    }

    /**
     * for testing purposes, wanted to keep ids in order and not have duplicates
     * since we arent letting users create players or teams
     */
    public void cleanUp(){
        playersRepo.deleteAll();
        matches.deleteAll();
    }

    private void createPlayers(){
        for(int i=0; i < 10; i++){
            teamOne.addBatter(Batsman.newBatter("england " + i));
            teamOne.addBowlers(Bowler.newBowler("Bowler_E_"+ i));
            teamTwo.addBatter(Batsman.newBatter("new zealand " + i));
            teamTwo.addBowlers(Bowler.newBowler("Bowler_Z_"+i));
        }
    }

    private void addAllPlayers(){
        int id=1;
        for(int i =0; i < teamOne.getBatters().length; i++){
            addBatter(teamOne.getBatters()[i], teamOne.getName(),id );
            id++;
            addBatter(teamTwo.getBatters()[i], teamTwo.getName(),id );
            id++;
            addBowler(teamOne.getBowlers()[i], teamOne.getName(),id );
            id++;
            addBowler(teamTwo.getBowlers()[i], teamTwo.getName(),id );
            id++;
        }
    }

    private void addBatter(Batsman b, String teamName, int id){
        Players p = new Players();
        p.setId(id);
        p.setName(b.getName());
        p.setTeam(teamName);
        p.setRuns(b.getRuns());
        p.setOuts(b.getOuts());
        p.setWickets(0);
        p.setPlayerType(1);
        playersRepo.save(p);
    }

    private void addBowler(Bowler b, String teamName,int id){
        Players p = new Players();
        p.setId(id);
        p.setName(b.getName());
        p.setTeam(teamName);
        p.setOuts(0);
        p.setRuns(0);
        p.setWickets(b.getWickets());
        p.setPlayerType(2);
        playersRepo.save(p);
    }


}
