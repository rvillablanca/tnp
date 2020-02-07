package cl.rvillablanca.tnp.controller;

import cl.rvillablanca.tnp.controller.beans.ErrorResponse;
import cl.rvillablanca.tnp.controller.exceptions.InvalidData;
import cl.rvillablanca.tnp.controller.exceptions.RequiredData;
import cl.rvillablanca.tnp.service.exceptions.TPNException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Rodrigo Villablanca <villa061004@gmail.com>
 */
public class BaseExceptionHandler {

    @ExceptionHandler({InvalidData.class, RequiredData.class})
    public ResponseEntity<ErrorResponse> clientErrorHandler(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setDescription(e.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> notReadable() {
        ErrorResponse error = new ErrorResponse();
        error.setDescription("invalid request payload");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<ErrorResponse> badCredentialsException() {
        ErrorResponse error = new ErrorResponse();
        error.setDescription("invalid credentials");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TPNException.class})
    public ResponseEntity<ErrorResponse> tpnException(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setDescription(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> unhandled() {
        ErrorResponse error = new ErrorResponse();
        error.setDescription("an unexpected error ocurred");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected RequiredData require(String description) throws RequiredData {
        return new RequiredData(description);
    }

    protected InvalidData invalid(String description) throws InvalidData {
        return new InvalidData(description);
    }
}
