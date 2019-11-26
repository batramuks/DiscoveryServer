package com.demo.moviecatalogservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import models.CatalogItem;
import models.Movie;
import models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		;
		// Get All movie Id
		List<Rating> ratingList = new ArrayList<Rating>();
		ratingList.add(new Rating("1234", "3"));
		ratingList.add(new Rating("5678", "5"));

		// For Each Movie Id call
	
		return ratingList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), "Movie1Desc", rating.getRating());
		}).collect(Collectors.toList());

	}

}
