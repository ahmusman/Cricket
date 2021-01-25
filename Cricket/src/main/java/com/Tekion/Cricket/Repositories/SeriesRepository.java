package com.Tekion.Cricket.Repositories;

import com.Tekion.Cricket.Models.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepository extends CrudRepository<Series,Integer> {


    @Query("SELECT s from Series s WHERE s.winner = ?1")
    Iterable<Series> seriesWonBy(String teamName);

}
