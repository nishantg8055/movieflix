package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.UserComments;


public interface UserCommentsService {

	public List<UserComments> findCommentsForMovie(String movId);
	
	public UserComments create(UserComments userComments);
}