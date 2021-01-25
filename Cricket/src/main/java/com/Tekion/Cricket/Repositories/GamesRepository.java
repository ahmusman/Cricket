package com.Tekion.Cricket.Repositories;


import com.Tekion.Cricket.Models.Games;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Games, Integer> {
}
