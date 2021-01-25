package com.Tekion.Cricket.Repositories;

import com.Tekion.Cricket.Models.Matches;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepository extends CrudRepository<Matches, Integer> {

    @Query("Select m FROM Matches m WHERE m.playerName = ?1")
    Iterable<Matches> getPlayersMatches(String name);

    @Query("Select m FROM Matches m WHERE m.matchId = ?1")
    Iterable<Matches> getMatchById(int matchNum);

}
