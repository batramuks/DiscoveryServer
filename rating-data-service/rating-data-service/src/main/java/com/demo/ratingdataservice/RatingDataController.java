package com.demo.ratingdataservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ratingdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("movieId", "MI4");
	}

}
