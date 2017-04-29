package io.egen.movieflix.service;

import io.egen.movieflix.entity.UserRating;

public interface UserRatingService {

	public Double findRatingsForMovie(String movId);
	
	public UserRating create(UserRating userRating);
}
