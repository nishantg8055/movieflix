package io.egen.movieflix.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.exception.UserAlreadyExistsException;
import io.egen.movieflix.exception.UserNotFoundException;
import io.egen.movieflix.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return existing;
	}

	
	@Override
	@Transactional
	public User create(User user) {
		User existing = userRepository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		user.setType("U");
		return userRepository.create(user);
	}

	
	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		user.setId(id);
		if("U".equalsIgnoreCase(existing.getType())){
			user.setType("U");
		}
		return userRepository.update(user);
	}

	
	@Override
	public void delete(String id) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		userRepository.delete(existing);
	}
}
