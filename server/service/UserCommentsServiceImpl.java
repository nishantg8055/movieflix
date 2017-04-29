package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.UserComments;
import io.egen.movieflix.repository.*;


@Service
public class UserCommentsServiceImpl implements UserCommentsService {

	@Autowired
	UserCommentsRepository userCommentsRepository;
	
	
	@Override
	public List<UserComments> findCommentsForMovie(String movId) {
		return userCommentsRepository.findCommentsForMovie(movId);
	}

	@Override
	@Transactional
	public UserComments create(UserComments userComments) {
		return userCommentsRepository.create(userComments);
	}

}