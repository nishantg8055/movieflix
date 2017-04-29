package io.egen.movieflix.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class MovieAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 405802649322364762L;

	public MovieAlreadyExistException(String message) {
		super(message);
	}

	public MovieAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
