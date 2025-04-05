package com.product.exception;

import org.springframework.http.HttpStatus;

/**
 * Excepción personalizada que se utiliza para manejar errores específicos en la API.
 * Esta excepción incluye un código de estado HTTP y un mensaje de error que se pueden
 * utilizar para proporcionar una respuesta detallada al cliente.
 * 
 * Esta clase extiende {@link RuntimeException}, lo que significa que es una excepción no verificada
 * y no necesita ser declarada en la firma del método.
 */
public class ApiException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private HttpStatus status;

    /**
     * Constructor que inicializa la excepción con un código de estado HTTP y un mensaje de error.
     * 
     * @param status El código de estado HTTP asociado con la excepción.
     * @param message El mensaje de error que describe la excepción.
     */
    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    /**
     * Obtiene el valor de {@code serialVersionUID}, que es un identificador único para esta clase.
     * 
     * @return El valor de {@code serialVersionUID}.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Obtiene el código de estado HTTP asociado con la excepción.
     * 
     * @return El código de estado HTTP.
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Establece el código de estado HTTP asociado con la excepción.
     * 
     * @param status El código de estado HTTP a establecer.
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
