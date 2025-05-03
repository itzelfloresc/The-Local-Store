package com.product.exception;

import org.springframework.dao.DataAccessException;

/**
 * Excepción personalizada que se utiliza para manejar errores relacionados con el acceso a la base de datos.
 * Esta excepción encapsula una excepción de tipo {@link DataAccessException} para proporcionar más detalles
 * sobre el error ocurrido durante las operaciones de base de datos.
 * 
 * Esta clase extiende {@link RuntimeException}, lo que significa que es una excepción no verificada
 * y no necesita ser declarada en la firma del método.
 */
public class DBAccessException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    private DataAccessException exception;

	/**
     * Constructor que inicializa la excepción con una excepción de acceso a la base de datos.
     * 
     * @param e La excepción de tipo {@link DataAccessException} que se desea encapsular.
     */
	public DBAccessException(DataAccessException e) {
		this.exception = e;
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
     * Obtiene la excepción de acceso a la base de datos encapsulada.
     * 
     * @return La excepción de tipo {@link DataAccessException}.
     */
	public DataAccessException getException() {
		return exception;
	}

	/**
     * Establece la excepción de acceso a la base de datos encapsulada.
     * 
     * @param exception La excepción de tipo {@link DataAccessException} a establecer.
     */
	public void setException(DataAccessException exception) {
		this.exception = exception;
	}
}

