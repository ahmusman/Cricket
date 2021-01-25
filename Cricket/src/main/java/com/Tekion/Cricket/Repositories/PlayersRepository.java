package com.Tekion.Cricket.Repositories;

import com.Tekion.Cricket.Models.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PlayersRepository extends JpaRepository<Players, Integer> {

    @Query("Select p from Players p where p.name = ?1")
    Iterable<Players> findPlayersNamed(String name);

    @Query("SELECT p from Players p WHERE p.playerType = 1")
    Iterable<Players> findBatters();

    @Query("SELECT p from Players p WHERE p.playerType = 2")
    Iterable<Players> findBowlers();

    @Query("SELECT p from Players p WHERE p.team like %?1")
    Iterable<Players> findByTeam(String teamName);

    @Query("SELECT p from Players p WHERE p.runs >= ?1")
    Iterable<Players> findPlayersWithRuns(int runs);
}
