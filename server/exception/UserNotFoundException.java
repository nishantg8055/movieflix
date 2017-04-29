package io.egen.movieflix.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 405802649322364762L;

	public UserNotFoundException(String msg){
		super(msg);
	}
	public UserNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
