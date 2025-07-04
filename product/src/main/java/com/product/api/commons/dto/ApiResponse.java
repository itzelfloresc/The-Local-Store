package com.product.api.commons.dto;

/**
 * Clase que representa una respuesta genérica de la API.
 * Esta clase se utiliza para encapsular un mensaje que será devuelto como respuesta
 * en las operaciones de la API, como creación, actualización, etc.
 */
public class ApiResponse {
//just trying something
    private String message;

    /**
     * Constructor que inicializa la respuesta con un mensaje específico.
     * 
     * @param message El mensaje que describe el resultado de la operación.
     */
    public ApiResponse(String message) {
        super();
        this.message = message;
    }

    /**
     * Obtiene el mensaje de la respuesta.
     * 
     * @return El mensaje que describe el resultado de la operación.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de la respuesta.
     * 
     * @param message El mensaje que describe el resultado de la operación.
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
