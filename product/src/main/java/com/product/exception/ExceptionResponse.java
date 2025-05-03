package com.product.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Clase que representa una respuesta de error en la API.
 * Esta clase encapsula información detallada sobre un error, incluyendo la marca de tiempo,
 * el código de estado HTTP, el mensaje de error y la ruta donde ocurrió el error.
 */
public class ExceptionResponse {

    /**
     * Marca de tiempo que indica cuándo ocurrió el error.
     * Se formatea como una cadena en el formato "yyyy-MM-dd hh:mm:ss".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    /**
     * Código de estado HTTP asociado con el error.
     */
    private Integer status;

    /**
     * Tipo de error HTTP asociado con el error.
     */
    private HttpStatus error;

    /**
     * Mensaje de error que describe el problema.
     */
    private String message;

    /**
     * Ruta de la API donde ocurrió el error.
     */
    private String path;

    /**
     * Obtiene la marca de tiempo que indica cuándo ocurrió el error.
     * 
     * @return La marca de tiempo.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la marca de tiempo que indica cuándo ocurrió el error.
     * 
     * @param timestamp La marca de tiempo a establecer.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtiene el código de estado HTTP asociado con el error.
     * 
     * @return El código de estado HTTP.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece el código de estado HTTP asociado con el error.
     * 
     * @param status El código de estado HTTP a establecer.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Obtiene el tipo de error HTTP asociado con el error.
     * 
     * @return El tipo de error HTTP.
     */
    public HttpStatus getError() {
        return error;
    }

    /**
     * Establece el tipo de error HTTP asociado con el error.
     * 
     * @param error El tipo de error HTTP a establecer.
     */
    public void setError(HttpStatus error) {
        this.error = error;
    }

    /**
     * Obtiene el mensaje de error que describe el problema.
     * 
     * @return El mensaje de error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de error que describe el problema.
     * 
     * @param message El mensaje de error a establecer.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene la ruta de la API donde ocurrió el error.
     * 
     * @return La ruta de la API.
     */
    public String getPath() {
        return path;
    }

    /**
     * Establece la ruta de la API donde ocurrió el error.
     * 
     * @param path La ruta de la API a establecer.
     */
    public void setPath(String path) {
        this.path = path;
    }


}
