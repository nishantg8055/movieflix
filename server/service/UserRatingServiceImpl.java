package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.entity.UserRating;
import io.egen.movieflix.repository.UserRatingRepository;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	UserRatingRepository userRatingRepository;
	@Override
	public Double findRatingsForMovie(String movId) {
		return userRatingRepository.findRatingsForMovie(movId);
	}

	@Override
	public UserRating create(UserRating userRating) {
		return userRatingRepository.create(userRating);
	}

}
