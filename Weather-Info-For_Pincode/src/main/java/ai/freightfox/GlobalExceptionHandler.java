package ai.freightfox;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ai.freightfox.payload.ErrorBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ErrorBody.class)
	public ResponseEntity<String> errorHandler(ErrorBody err){
		return new ResponseEntity<String>(err.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
