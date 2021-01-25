package com.Tekion.Cricket.Service;

import com.Tekion.Cricket.Models.Games;
import com.Tekion.Cricket.Models.Matches;
import com.Tekion.Cricket.Models.Players;
import com.Tekion.Cricket.Models.Series;

import java.util.Optional;

public interface Services {

    String initiateGame(int numMatches, int numOvers);

    Iterable<Games> findAllGames();

    Iterable<Players> findAllPlayers();

    Iterable<Players> findAllBatters();

    Iterable<Players> findAllBowlers();

    Iterable<Players> findPlayersByTeam(String teamName);

    Optional<Players> findPlayerById(int id);

    Iterable<Players> findPlayersByName(String playerName);

    Iterable<Players> findPlayersWithAtLeastRuns(int runs);

    String seriesWinner();

    Iterable<Series> showAllSeries();

    Optional<Series> showSeries(int seriesId);

    Iterable<Series> showSeriesWonBy(String winner);

    Iterable<Matches> showAllMatches();

    Iterable<Matches> getMatchesByPlayer(String name);

    Iterable<Matches> getMatchesByMatchNum(int matchNum);

}
