package io.egen.movieflix.repository;

import io.egen.movieflix.entity.UserRating;


public interface UserRatingRepository {

	public Double findRatingsForMovie(String movId);
	
	public UserRating create(UserRating userRating);


}