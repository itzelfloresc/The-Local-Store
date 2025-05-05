package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.commons.dto.ApiResponse;
import com.product.api.entity.Category;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;

/**
 * Implementación de la interfaz {@link SvcCategory} que proporciona la lógica de negocio
 * para manejar las operaciones relacionadas con las categorías. Esta clase interactúa con
 * el repositorio {@link RepoCategory} para realizar operaciones en la base de datos.
 * 
 * Los métodos de esta clase manejan excepciones de acceso a la base de datos y lanzan
 * excepciones personalizadas como {@link ApiException} y {@link DBAccessException} para
 * manejar errores específicos.
 */
@Service
public class SvcCategoryImp implements SvcCategory{
    @Autowired
    RepoCategory repo;

	/**
     * Obtiene una lista de todas las categorías.
     * 
     * @return Una respuesta HTTP con la lista de categorías.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public ResponseEntity<List<Category>> getCategories() {
        try {
            return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

	/**
     * Obtiene una lista de todas las categorías activas.
     * 
     * @return Una respuesta HTTP con la lista de categorías activas.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<List<Category>> getActiveCategories() {
		try {
			return new ResponseEntity<>(repo.getActiveCategories(), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	/**
     * Obtiene una categoría específica por su ID.
     * 
     * @param id El ID de la categoría que se desea obtener.
     * @return Una respuesta HTTP con la categoría solicitada.
     * @throws ApiException Si el ID de la categoría no existe.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<Category> getCategory(Integer id) {
		try {
			validateCategoryId(id);
			return new ResponseEntity<>(repo.getCategory(id), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	/**
     * Crea una nueva categoría en la base de datos.
     * 
     * @param in El objeto {@link DtoCategoryIn} que contiene los datos de la nueva categoría.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si el nombre de la categoría o el tag ya están registrados.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in) {
		try {
			repo.createCategory(in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido registrada"), HttpStatus.CREATED);
		}catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_category"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoria ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoría ya está registrado");

			throw new DBAccessException(e);
		}
	}

	/**
     * Actualiza una categoría existente en la base de datos.
     * 
     * @param in El objeto {@link DtoCategoryIn} que contiene los nuevos datos de la categoría.
     * @param id El ID de la categoría que se desea actualizar.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si el ID de la categoría no existe o si el nombre de la categoría o el tag ya están registrados.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<ApiResponse> updateCategory(DtoCategoryIn in, Integer id) {
		try {
            if(repo.findById(id).isEmpty())
	            throw new ApiException(HttpStatus.NOT_FOUND, "El id de la categoria no existe");
			repo.updateCategory(id, in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido actualizada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_region"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoria ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la región ya está registrado");

			throw new DBAccessException(e);
		}
	}

	/**
     * Habilita una categoría en la base de datos.
     * 
     * @param id El ID de la categoría que se desea habilitar.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si el ID de la categoría no existe.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<ApiResponse> enableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.enableCategory(id);
			return new ResponseEntity<>(new ApiResponse("La categoria ha sido activada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	/**
     * Deshabilita una categoría en la base de datos.
     * 
     * @param id El ID de la categoría que se desea deshabilitar.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si el ID de la categoría no existe.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    @Override
	public ResponseEntity<ApiResponse> disableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.disableCategory(id);
			return new ResponseEntity<>(new ApiResponse("La categoria ha sido desactivada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	/**
     * Valida si una categoría existe en la base de datos.
     * 
     * @param id El ID de la categoría que se desea validar.
     * @throws ApiException Si el ID de la categoría no existe.
     * @throws DBAccessException Si ocurre un error al acceder a la base de datos.
     */
    private void validateCategoryId(Integer id) {
		try {
			if(repo.getCategory(id) == null) {
				throw new ApiException(HttpStatus.NOT_FOUND, "El id de la categoria no existe");
			}
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

}
