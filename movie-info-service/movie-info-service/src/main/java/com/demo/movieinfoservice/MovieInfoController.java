package com.demo.movieinfoservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieinfoservice.models.Movie;



@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfor(@PathVariable("movieId") String movieId) {
		return new Movie("movieId", "Transformer");
	}

}
