package io.egen.movieflix.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.service.*;
import io.egen.movieflix.entity.*;

@RestController
@RequestMapping(path="movies")
public class MovieController {
	@Autowired
	MovieService service;
	@Autowired
	UserCommentsService userCommentsService;
	
	@Autowired
	UserRatingService userRatingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String movId) {
		return service.findOne(movId);
	}

	

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String movId) {
		service.delete(movId);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movId, @RequestBody Movie movie) {
		return service.update(movId, movie);
	}
	@RequestMapping(method = RequestMethod.GET, path = "{id}/user-comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserComments> findAllComments(@PathVariable("id") String movId) {
		return userCommentsService.findCommentsForMovie(movId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}/avg-rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double findMovieRationg(@PathVariable("id") String movId) {
		return userRatingService.findRatingsForMovie(movId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{movId}/users/{userId}/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating postMovieRationg(@PathVariable("movId") String movId,@PathVariable("userId") String userId, @RequestParam Double rating) {
		UserRating userRating = new UserRating();
		if(userRating.getMovie() == null){
			userRating.setMovie(new Movie());
		}
		if(userRating.getUser() == null){
			userRating.setUser(new User());
		}
		userRating.getMovie().setId(movId);
		userRating.getUser().setId(userId);
		userRating.setRating(rating);
		return userRatingService.create(userRating);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{movId}/users/{userId}/user-comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComments postUserComments(@PathVariable("movId") String movId,@PathVariable("userId") String userId, @RequestParam String comments) {
		UserComments userComments = new UserComments();
		if(userComments.getMovie() == null){
			userComments.setMovie(new Movie());
		}
		if(userComments.getUser() == null){
			userComments.setUser(new User());
		}
		userComments.getMovie().setId(movId);
		userComments.getUser().setId(userId);
		userComments.setComments(comments);
		return userCommentsService.create(userComments);
	}
}

