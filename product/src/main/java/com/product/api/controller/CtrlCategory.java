package com.product.api.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.product.api.commons.dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.exception.ApiException;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


/**
 * Controlador REST que maneja las solicitudes HTTP relacionadas con las categorías de productos.
 * Este controlador expone endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre las categorías, así como para habilitar o deshabilitar categorías.
 * 
 * Todas las operaciones se realizan a través del servicio {@link SvcCategory}, que es inyectado
 * automáticamente por Spring.
 * 
 * La ruta base para todos los endpoints es {@code /category}.
 */
@RestController
@RequestMapping("/category")
@Tag(name = "Categoría", description = "Catálogo de categorias")
public class CtrlCategory {

    @Autowired
    SvcCategory svc;

    /**
     * Obtiene una lista de todas las categorías.
     * 
     * @return Una respuesta HTTP con la lista de categorías.
     */
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return svc.getCategories();
    }

    /**
     * Obtiene una lista de todas las categorías activas.
     * 
     * @return Una respuesta HTTP con la lista de categorías activas.
     */
    @GetMapping("/active")
    public ResponseEntity<List<Category>> getActiveCategories() { 
        return svc.getActiveCategories();
    }

    /**
     * Crea una nueva categoría.
     * 
     * @param in El objeto {@link DtoCategoryIn} que contiene los datos de la nueva categoría.
     * @param bindingResult El resultado de la validación de los datos de entrada.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si los datos de entrada no son válidos.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody DtoCategoryIn in, BindingResult bindingResult){ 
        if(bindingResult.hasErrors()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return svc.createCategory(in);
    }

    /**
     * Actualiza una categoría existente.
     * 
     * @param id El ID de la categoría que se desea actualizar.
     * @param in El objeto {@link DtoCategoryIn} que contiene los nuevos datos de la categoría.
     * @param bindingResult El resultado de la validación de los datos de entrada.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si los datos de entrada no son válidos.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("id") Integer id, @Valid @RequestBody DtoCategoryIn in, BindingResult bindingResult) { 
        if(bindingResult.hasErrors()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return svc.updateCategory(in, id);
    }

    /**
     * Habilita una categoría.
     * 
     * @param id El ID de la categoría que se desea habilitar.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     */
    @PatchMapping("/{id}/enable")
    public ResponseEntity<ApiResponse> enableCategory(@PathVariable("id") Integer id) { 
        return svc.enableCategory(id);
    }

    /**
     * Deshabilita una categoría.
     * 
     * @param id El ID de la categoría que se desea deshabilitar.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     */
    @PatchMapping("/{id}/disable")
    public ResponseEntity<ApiResponse> disableCategory(@PathVariable("id") Integer id) { 
        return svc.disableCategory(id);
    }

    /**
     * Obtiene una categoría específica por su ID.
     * 
     * @param id El ID de la categoría que se desea obtener.
     * @return Una respuesta HTTP con la categoría solicitada.
     */
    @GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
		return svc.getCategory(id);
	}
}
