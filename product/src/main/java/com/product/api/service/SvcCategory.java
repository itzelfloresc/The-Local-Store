package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.commons.dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;

/**
 * Interfaz que define los métodos para un servicio que maneja la lógica de negocio
 * relacionada con las categorías. Este servicio proporciona operaciones para obtener,
 * crear, actualizar, habilitar y deshabilitar categorías.
 * 
 * Los métodos devuelven objetos {@link ResponseEntity} que encapsulan la respuesta HTTP,
 * incluyendo el cuerpo de la respuesta y el código de estado.
 */
public interface SvcCategory {
    public ResponseEntity<List<Category>> getCategories();
    public ResponseEntity<List<Category>> getActiveCategories();
    public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in);
    public ResponseEntity<ApiResponse> updateCategory(DtoCategoryIn in, Integer id);
    public ResponseEntity<ApiResponse> enableCategory(Integer id);
    public ResponseEntity<ApiResponse> disableCategory(Integer id);
    public ResponseEntity<Category> getCategory(Integer id);
}
