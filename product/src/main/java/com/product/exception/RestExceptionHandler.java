package com.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Manejador global de excepciones que captura excepciones específicas y devuelve respuestas HTTP personalizadas.
 * Esta clase extiende {@link ResponseEntityExceptionHandler} para manejar excepciones en controladores
 * y proporcionar respuestas consistentes en toda la API.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Maneja excepciones de tipo {@link ApiException}.
     * 
     * @param exception La excepción de tipo {@link ApiException} que se capturó.
     * @param request La solicitud web que causó la excepción.
     * @return Una respuesta HTTP personalizada con detalles del error.
     */
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ExceptionResponse> handleApiException(ApiException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(exception.getStatus().value());
        response.setError(exception.getStatus());
        response.setMessage(exception.getMessage());
        response.setPath(((ServletWebRequest) request).getRequest().getRequestURI().toString());
        return new ResponseEntity<>(response, response.getError());
    }

    /**
     * Maneja excepciones de tipo {@link DBAccessException}.
     * 
     * @param exception La excepción de tipo {@link DBAccessException} que se capturó.
     * @param request La solicitud web que causó la excepción.
     * @return Una respuesta HTTP personalizada con detalles del error.
     */
    @ExceptionHandler(DBAccessException.class)
    protected ResponseEntity<ExceptionResponse> DBAccessException(DBAccessException exception, WebRequest request) {

        System.out.println(exception.getException().getLocalizedMessage());

        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMessage("Error al consultar la base de datos");
        response.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());

        return new ResponseEntity<>(response, response.getError());
    }
}
