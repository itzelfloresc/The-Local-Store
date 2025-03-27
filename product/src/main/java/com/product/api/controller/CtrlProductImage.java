package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.commons.dto.ApiResponse;
import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;
import com.product.exception.ApiException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controlador REST que maneja las solicitudes HTTP relacionadas con las imágenes de los productos.
 * Este controlador expone endpoints para realizar operaciones de crear una imagen y eliminar una imagen.
 * 
 * Todas las operaciones se realizan a través del servicio {@link SvcProductImage}, que es inyectado
 * automáticamente por Spring.
 * 
 * La ruta base para todos los endpoints es {@code /product-image}.
 */
@RestController
@RequestMapping("/product-image")
public class CtrlProductImage {

    @Autowired
    SvcProductImage svc;

    /**
     * Crea una nueva imagen para un producto.
     * @param in El objeto {@link DtoProductImageIn} que contiene los datos de la nueva imagen.
     * @param bindingResult El resultado de la validación de los datos de entrada.
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     * @throws ApiException Si los datos de entrada no son válidos.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> createProductImage(@Valid @RequestBody DtoProductImageIn in, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
        return svc.createProductImage(in);
    }
    
    /**
     * Elimina una imagen de un producto
     * @param product_image_id El id de la imagen a eliminar
     * @return Una respuesta HTTP con un mensaje de éxito o error.
     */
    @DeleteMapping("/{product_image_id}")
    public ResponseEntity<ApiResponse> deleteProductImage(@PathVariable("product_image_id") Integer product_image_id) {
        return svc.deleteProductImage(product_image_id);
    }
}
