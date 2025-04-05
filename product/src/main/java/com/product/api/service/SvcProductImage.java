package com.product.api.service;

import org.springframework.http.ResponseEntity;

import com.product.api.commons.dto.ApiResponse;
import com.product.api.dto.in.DtoProductImageIn;

/**
 * Interfaz que define los métodos para un servicio que maneja la lógica de negocio
 * relacionada con las imagenes de productos.
 * Este servicio proporciona operaciones para crear y eliminar imagenes.
 */
public interface SvcProductImage {

    public ResponseEntity<ApiResponse> createProductImage(DtoProductImageIn in);
    public ResponseEntity<ApiResponse> deleteProductImage(Integer product_image_id);
}
