package com.movielist.movielist.service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movielist.movielist.domain.MovieList;
import com.movielist.movielist.repository.movieRepository;

@Service
public class movieListService {

	@Autowired
	movieRepository movierepository;
	
	public List<MovieList> getByGenre(String genre){
		return movierepository.findByGenre(genre);
		
		
		
	}
	public List<MovieList> getByRating(Float rating){
		return movierepository.findByRating(rating);
	}

	public List<MovieList> getAllMovies() {
		return movierepository.findAll();
	}

	public MovieList getbyid(Integer id) {
		return movierepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

	}

	public void deleteMovie(Integer id) {
		 movierepository.deleteById(id);
	}

	public MovieList createMovie(MovieList addmovie) {
	
		
		return  movierepository.save(addmovie);
		
		

	}
	public Map<String,Long> countByGenre(){
		List<MovieList> movies=movierepository.findAll();
		return movies.stream().collect(Collectors.groupingBy(MovieList:: getGenre,Collectors.counting()));
	
	}

	public MovieList updateMovie(Integer id, MovieList updatedMovie) {
		MovieList existingmovie = movierepository.findById(id)
				.orElseThrow(() -> new RuntimeException("movie not found"));
		existingmovie.setName(updatedMovie.getName());
		existingmovie.setGenre(updatedMovie.getGenre());
		existingmovie.setRating(updatedMovie.getRating());
		existingmovie.setTicketPrice(updatedMovie.getTicketPrice());
		return movierepository.save(existingmovie);
	}
	public List<MovieList> sortByPrice(String order){
		Sort sort= order.equalsIgnoreCase("asc")? Sort.by("ticketPrice").ascending():Sort.by("ticketPrice").descending();
		return movierepository.findAll(sort);
	
	}
	public List<MovieList> createbulkmovies(List<MovieList> movielist){
		return movierepository.saveAll(movielist);
		
	}

}
