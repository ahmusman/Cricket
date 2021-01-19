package com.Tekion.Cricket;

import com.Tekion.Cricket.Matches;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Matches, Integer> {
}
