package io.egen.movieflix.repository;

import java.util.List;
import io.egen.movieflix.entity.*;

public interface UserCommentsRepository {
	
	public List<UserComments> findCommentsForMovie(String movId);
	
	public UserComments create(UserComments userComments);

}
