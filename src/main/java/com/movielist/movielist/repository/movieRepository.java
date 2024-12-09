package com.movielist.movielist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movielist.movielist.domain.MovieList;

@Repository
public interface movieRepository extends JpaRepository <MovieList,Integer> {
	List<MovieList> findByGenre(String genre);
	List<MovieList> findByRating(Float rating);

}
