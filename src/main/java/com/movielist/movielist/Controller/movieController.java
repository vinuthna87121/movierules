package com.movielist.movielist.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movielist.movielist.domain.MovieList;
import com.movielist.movielist.service.movieListService;

@RequestMapping("/movielist")
@RestController
public class movieController {
	
	@Autowired
	movieListService movielistservice;
	
	
	@GetMapping("/count-by-genre")
	public Map<String,Long> groupByGenre(){
		return movielistservice.countByGenre();
	}
	@GetMapping
	public List<MovieList> getall(){
		return movielistservice.getAllMovies();
	}
	@GetMapping("/{id}")
	public ResponseEntity<MovieList> getByid(@PathVariable Integer id) {
		MovieList ml= movielistservice.getbyid(id);
		if(ml != null) {
			return ResponseEntity.ok(ml);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@GetMapping("rating/{rating}")
	public List<MovieList> getByRtaing(@PathVariable  Float rating){
		return movielistservice.getByRating(rating);
		
	}
	
	
	
	
	@GetMapping("/genre/{genre}")
	public ResponseEntity<List<MovieList> >getbygenre(@PathVariable String genre){
		List<MovieList> getgenre= movielistservice.getByGenre(genre);
		if(getgenre != null) {
			return ResponseEntity.ok(getgenre);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	@GetMapping("/sort/price")
    public List<MovieList> getMoviesSortedByPrice(@RequestParam(defaultValue = "asc") String order) {
        return movielistservice.sortByPrice(order);
    }
	
	@PostMapping("/bulk-create")
	public List<MovieList> createbulk(@RequestBody List<MovieList> movielist){
		return movielistservice.createbulkmovies(movielist);
		
	}
	
	
	@PutMapping("/update/{id}")
	public MovieList updatemovie(@PathVariable Integer id, @RequestBody MovieList updatedmovie ) {
		return movielistservice.updateMovie(id, updatedmovie);
		
	}
	@DeleteMapping("/delete/{id}")
	public void  deletemovie(@PathVariable Integer id){
		  movielistservice.deleteMovie(id);
	
}
	@PostMapping("/create")
	public MovieList createMovie(@RequestBody MovieList addMovie) {
		return movielistservice.createMovie(addMovie);
	}
}
